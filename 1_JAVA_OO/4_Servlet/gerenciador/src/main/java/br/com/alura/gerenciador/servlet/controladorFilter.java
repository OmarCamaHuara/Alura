package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Action;

// @WebFilter("/controladorFilter")
public class controladorFilter extends HttpFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("Controler Filter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession session = request.getSession();	// pego o cooki da seção
		boolean thisLogedUser = session.getAttribute("loguedUser") == null;
		boolean restrictClasses = !(paramAcao.equals("formLoginUser") || paramAcao.equals("loginUser"));
		if(thisLogedUser && restrictClasses) {
			response.sendRedirect("entrada?acao=formLoginUser");
			return;
		}
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao."+ paramAcao;
		
		String nome;
		try {
			
			Class classe = Class.forName(nomeDaClasse); // Carrrega a classe com o nome
			Action acao = (Action) classe.newInstance();
			nome = acao.executa(request, response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		} 
		
		String[] acaoResposta = nome.split(":");
		if(acaoResposta[0].equals("forward")) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + acaoResposta[1]);
		rd.forward(request, response);
		}else {
			response.sendRedirect(acaoResposta[1]);
		}
	}
}

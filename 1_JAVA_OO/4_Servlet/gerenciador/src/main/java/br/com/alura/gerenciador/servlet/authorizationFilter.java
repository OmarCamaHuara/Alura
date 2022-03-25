package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/entrada")
public class authorizationFilter extends HttpFilter implements Filter {
     
	public void init(FilterConfig filterConfig) throws ServletException {}
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Authotization Filter");
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

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}

package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Action;
import br.com.alura.gerenciador.acao.alteraEmpresa;
import br.com.alura.gerenciador.acao.listaDeEmpresas;
import br.com.alura.gerenciador.acao.mostraEmpresa;
import br.com.alura.gerenciador.acao.novaEmpresa;
import br.com.alura.gerenciador.acao.novaEmpresaForm;
import br.com.alura.gerenciador.acao.removeEmpresa;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		

		HttpSession session = request.getSession();	// pego o cooki da seção
		boolean thisLogedUser = session.getAttribute("loguedUser") == null;
		boolean restrictClasses = !(paramAcao.equals("formLoginUser") || paramAcao.equals("loginUser"));
		if(thisLogedUser && restrictClasses) {
			response.sendRedirect("entrada?acao=formLoginUser");
			return;
		}
		
		System.out.println("Pasouuuuu");
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao."+ paramAcao;
		
		
		
		String nome;
		try {
			
			Class classe = Class.forName(nomeDaClasse); // Carrrega a classe com o nome
//			Object obj = classe.newInstance();
//			Action acao = (Action) obj;
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
		
//		String nome = null;
//		if(paramAcao.equals("listaDeEmpresas")) {
//			ListaEmpresa acao = new ListaEmpresa();
//			nome = acao.executa(request, response);		
//		}else if(paramAcao.equals("alteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		}else if(paramAcao.equals("mostraEmpresa")){
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		}else if(paramAcao.equals("novaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		}else if(paramAcao.equals("removeEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//		}else if(paramAcao.equals("novaEmpresaForm") ) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
		
		
	}


}

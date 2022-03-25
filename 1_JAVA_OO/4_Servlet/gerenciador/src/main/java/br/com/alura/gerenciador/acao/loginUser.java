package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.User;

public class loginUser implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		Banco banco = new Banco();
		User userLogin = banco.existCont(user, password);
		
		//System.out.println(userLogin + " "+ user + " " + password );
		
		if(userLogin != null) {
			HttpSession session = request.getSession(); // pega a cooki ou session nro
			session.setAttribute("loguedUser", userLogin);
			System.out.println(session);
	
			return "redirect:entrada?acao=listaDeEmpresas";
		}else {
			return "redirect:entrada?acao=formLoginUser";
		}
		
	}

}

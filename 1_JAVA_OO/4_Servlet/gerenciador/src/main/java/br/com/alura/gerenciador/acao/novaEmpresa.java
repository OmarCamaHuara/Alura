package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class novaEmpresa implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastro nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDateEmpresa = request.getParameter("date");
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDateEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
	
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDate(dataAbertura);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		return "redirect:entrada?acao=listaDeEmpresas";
		
//		response.sendRedirect("entrada?acao=listaDeEmpresas");
		
	}

}

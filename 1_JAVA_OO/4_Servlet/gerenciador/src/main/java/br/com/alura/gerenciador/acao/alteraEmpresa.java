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

public class alteraEmpresa implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Alterando empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDateEmpresa = request.getParameter("date");
		String paramId = request.getParameter("id");
		
		Integer id= Integer.valueOf(paramId);
		
		System.out.println(nomeEmpresa);
		System.out.println(paramDateEmpresa);
		System.out.println(id);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDateEmpresa);
		}catch(ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDate(dataAbertura);
		
		return "redirect:entrada?acao=listaDeEmpresas";
		
		//response.sendRedirect("entrada?acao=listaDeEmpresas");
	}

}

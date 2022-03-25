package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class ListaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresa = new Banco().getEmpresas();	
		
		String value = request.getHeader("Accept");
		
		if(value.endsWith("xml")) {
			
			// libreria XStream para formato XML
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(empresa);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
			
		}else if(value.endsWith("json")) {
			// libreria Gson que dentro de uma string guarda um formato json
			Gson gson = new Gson();
			String json = gson.toJson(empresa);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		}else {
			response.setContentType("application/json");
			response.getWriter().print("{'message' : 'no content'}");
		}
		
		
		
	}
}

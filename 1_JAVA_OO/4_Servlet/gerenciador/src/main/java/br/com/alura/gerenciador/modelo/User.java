package br.com.alura.gerenciador.modelo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Action;

public class User {
	private String user;
	private String password;
	
	
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validator(String user, String password) {
		System.out.println(2+" "+user + " " + password);
		
		if(this.password.equals(password) && this.user.equals(user)) {
			return true;
		}
		return false;
	}
}

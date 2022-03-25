package br.com.alura.gerenciador.modelo;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<User> listUser = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Domar");
		lista.add(empresa);
		lista.add(empresa2);
		
		User usu1 = new User();
		usu1.setPassword("123");
		usu1.setUser("domar");

		User usu2 = new User();
		usu2.setPassword("2023");
		usu2.setUser("on");
		
		listUser.add(usu2);
		listUser.add(usu1);
		
		
	}

	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
			
		}
		
//		for(Empresa empresa : lista) {
//			if(empresa.getId() == id) {
//				lista.remove(empresa);
//			}
//		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for(Empresa empresa : lista) {
			if(empresa.getId() == id ) {
				return empresa;
			}
		}
		return null;
	}

	public User existCont(String userConta, String password) {
		System.out.println(1 +" "+userConta + " " + password);
		for(User usuario : listUser) {
			System.out.println(usuario.getUser());
			if(usuario.validator(userConta, password)) {
				return usuario;
			}
		}
		return null;
	}
}

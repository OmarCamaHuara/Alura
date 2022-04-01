package br.com.domar.mvc.edomar.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.domar.mvc.edomar.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setProductName("Curso de Arduino");
		pedido.setDeliveryDate("01/01/2023");
		pedido.setDescription("Arduino é uma plataforma de código livre (opensource) composta por dois componentes: o hardware, que é a placa onde são construídos os projetos; e o software, que é a IDE Arduino, onde é programado ou escrito o que se deseja que a placa realize. Dessa forma, a placa, que é composta por um microcontrolador Atmel, pode ser conectada a um computador e programada via IDE, para os mais diversos usos (a criatividade é o limite): controlar as luzes de algum ambiente, um robô, automatizar sua casa, melhorar algum equipamento, etc.");
		pedido.setUrlProduct("https://www.primecursos.com.br/arduino-basico/");
		pedido.setImage("https://www.primecursos.com.br/arquivos/uploads/2020/02/curso-arduino-basico.jpg");
		
		List<Pedido> listaPedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", listaPedidos);
		
		return "home";
	}
}

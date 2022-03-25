package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/entrada")
public class monitoringFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Monitoring filter");
		
		long before = System.currentTimeMillis();
		
		String action = request.getParameter("acao");
		
		//measure the execute time of action
		chain.doFilter(request, response);
		
		long later = System.currentTimeMillis();
		
		System.out.println("Runtime of "+ action + "is "+ (later - before));
		
	}

}

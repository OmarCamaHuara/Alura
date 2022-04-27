package br.com.alura.forum.security;

import br.com.alura.forum.Repository.UsersRepository;
import br.com.alura.forum.modelo.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsersRepository usersRepository;

    public AuthenticationViaTokenFilter(TokenService tokenService, UsersRepository usersRepository){
        this.tokenService = tokenService;
        this.usersRepository = usersRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
//        System.out.println(token);
        boolean valido = tokenService.isTokenValido(token);
//        System.out.println(valido);
        if(valido){
            authenticateCustomer(token);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticateCustomer(String token) {
        Long idUser = tokenService.getIdUser(token);
        User user = usersRepository.findById(idUser).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
}

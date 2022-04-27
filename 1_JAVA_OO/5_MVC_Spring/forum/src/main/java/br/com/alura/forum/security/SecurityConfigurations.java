package br.com.alura.forum.security;

import br.com.alura.forum.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutencationService autenticationService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    // Confguracao de autenticacao
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("Domain");
        auth.userDetailsService(autenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Configuracoes de Autorizacao
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/topics").permitAll()
                .antMatchers(HttpMethod.GET, "/topics/*").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/actuator/**").permitAll()
                .anyRequest().authenticated()
                //.and().formLogin(); nao vamos a utilizar mais porque agora a autenticacao vai ser por token
                .and().csrf().disable() // precisa esta desabilitado porque nossa autenticacao e por token
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AuthenticationViaTokenFilter(tokenService, usersRepository), UsernamePasswordAuthenticationFilter.class); // avisando que nossa autenticacao vai ser stateless
    }

    // Configuracoes de recursos estaticos (js, css, img, etc.)
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    // Para gerar o password
//    public static void main(String[] args){
//        System.out.println(new BCryptPasswordEncoder().encode("808023"));
//    }
}

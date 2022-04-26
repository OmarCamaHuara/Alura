package br.com.alura.forum.security;

import br.com.alura.forum.Repository.UsersRepository;
import br.com.alura.forum.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutencationService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findByEmail(username);
        if (user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Dados invalidos");
    }
}

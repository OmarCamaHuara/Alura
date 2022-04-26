package br.com.alura.forum.Repository;

import br.com.alura.forum.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByPassword(String password);
}

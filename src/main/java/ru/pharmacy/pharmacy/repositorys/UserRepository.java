package ru.pharmacy.pharmacy.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.entiteis.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);
}

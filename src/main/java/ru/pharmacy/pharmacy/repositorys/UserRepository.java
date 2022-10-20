package ru.pharmacy.pharmacy.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

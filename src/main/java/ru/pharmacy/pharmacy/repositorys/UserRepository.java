package ru.pharmacy.pharmacy.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.entiteis.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String username);
}

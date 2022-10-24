package ru.pharmacy.pharmacy.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.entiteis.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}

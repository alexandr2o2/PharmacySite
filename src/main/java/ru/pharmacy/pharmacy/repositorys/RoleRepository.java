package ru.pharmacy.pharmacy.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.entiteis.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

}

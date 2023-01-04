package ru.pharmacy.pharmacy.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.pharmacy.pharmacy.entiteis.ManufacturerEntity;

import java.util.List;


public interface ManufacturerRepo extends JpaRepository<ManufacturerEntity,Long> {
    List<ManufacturerEntity> findAllByName(String name);
}

package ru.pharmacy.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.entiteis.ManufacturerEntity;
import ru.pharmacy.pharmacy.entiteis.MedicineEntity;

import java.util.List;
import java.util.Optional;


public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity,Long> {
    List<ManufacturerEntity> findAllByName(String name);
    MedicineEntity findById(long id);
    Optional<MedicineEntity> findByName(String name);
}

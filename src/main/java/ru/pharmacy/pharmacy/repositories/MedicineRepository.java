package ru.pharmacy.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.entiteis.MedicineEntity;

import java.util.List;
import java.util.Optional;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {
    Optional<MedicineEntity> findById(Long id);
    List<MedicineEntity> findAllByName(String name);
}

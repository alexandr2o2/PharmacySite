package ru.pharmacy.pharmacy.services;

import org.springframework.data.repository.CrudRepository;
import ru.pharmacy.pharmacy.entiteis.MedicineEntity;

import java.util.Optional;

public interface MedicineService extends CrudRepository<MedicineEntity, Long> {
    MedicineEntity findById(long id);
    Optional<MedicineEntity> findByName(String name);
}

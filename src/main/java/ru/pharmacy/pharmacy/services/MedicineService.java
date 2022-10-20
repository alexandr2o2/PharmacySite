package ru.pharmacy.pharmacy.services;

import org.springframework.data.repository.CrudRepository;
import ru.pharmacy.pharmacy.models.Medicine;

import java.util.Optional;

public interface MedicineService extends CrudRepository<Medicine, Long> {
    Medicine findById(long id);
    Optional<Medicine> findByName(String name);
}

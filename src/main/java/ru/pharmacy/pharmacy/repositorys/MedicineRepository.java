package ru.pharmacy.pharmacy.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.entiteis.MedicineEntity;

import java.util.List;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {

    List<MedicineEntity> findAllByName(String name);
}

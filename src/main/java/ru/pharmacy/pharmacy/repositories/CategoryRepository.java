package ru.pharmacy.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pharmacy.pharmacy.entiteis.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}

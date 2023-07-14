package ru.prostor.cms.core.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.prostor.cms.core.backend.model.entity.CategoryEntity;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
    @Query(value = "select ce from CategoryEntity ce where ce.title = :categoryTitle")
    CategoryEntity findCategoryEntityByTitle(@Param("categoryTitle") String categoryTitle);

    CategoryEntity findCategoryEntityById(UUID categoryId);
}

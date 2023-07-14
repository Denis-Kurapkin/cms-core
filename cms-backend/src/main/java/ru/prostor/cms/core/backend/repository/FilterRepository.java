package ru.prostor.cms.core.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.prostor.cms.core.backend.model.entity.FilterEntity;

import java.util.List;
import java.util.UUID;

public interface FilterRepository extends JpaRepository<FilterEntity, UUID> {
    @Query(value = "select f from FilterEntity f " +
            "where f.attribute.title in (:filterTitles)")
    List<FilterEntity> findFilterEntitiesByTitle(@Param("filterTitles") List<String> filterTitles);

    @Query(value = "select f from filter f " +
            "join filter_j_category fc on f.filter_id = fc.filter_id " +
            "where fc.category_id = :categoryId", nativeQuery = true)
    List<FilterEntity> findFilterEntitiesByCategoryId(@Param("categoryId") UUID categoryId);
}

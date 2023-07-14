package ru.prostor.cms.core.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.prostor.cms.core.backend.model.entity.AttributeValueEntity;

import java.util.List;
import java.util.UUID;

public interface AttributeValueRepository extends JpaRepository<AttributeValueEntity, UUID> {
    List<AttributeValueEntity> findAttributeValueEntitiesByIdIn(List<UUID> attributeValueIds);
}

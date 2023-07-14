package ru.prostor.cms.core.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.prostor.cms.core.backend.model.entity.AttributeEntity;

import java.util.UUID;

public interface AttributeRepository extends JpaRepository<AttributeEntity, UUID> {
}
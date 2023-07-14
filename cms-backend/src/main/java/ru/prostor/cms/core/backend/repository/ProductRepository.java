package ru.prostor.cms.core.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.prostor.cms.core.backend.model.entity.ProductEntity;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}

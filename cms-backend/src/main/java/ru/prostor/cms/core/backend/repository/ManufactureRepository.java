package ru.prostor.cms.core.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.prostor.cms.core.backend.model.entity.ManufacturerEntity;

import java.util.UUID;

@Repository
public interface ManufactureRepository extends JpaRepository<ManufacturerEntity, UUID> {

    ManufacturerEntity findManufacturerEntityById(UUID manufacturerId);
}

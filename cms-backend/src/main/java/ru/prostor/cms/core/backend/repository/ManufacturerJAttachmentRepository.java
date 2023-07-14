package ru.prostor.cms.core.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.prostor.cms.core.backend.model.entity.ManufacturerJAttachmentEntity;

@Repository
public interface ManufacturerJAttachmentRepository
        extends JpaRepository<ManufacturerJAttachmentEntity, ManufacturerJAttachmentEntity.ManufacturerJAttachmentCompositeKey> {
}

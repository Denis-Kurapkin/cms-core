package ru.prostor.cms.core.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.prostor.cms.core.backend.model.entity.AttachmentEntity;

import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<AttachmentEntity, UUID> {
}

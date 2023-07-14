package ru.prostor.cms.core.backend.mapper;

import ru.prostor.cms.core.backend.model.dto.response.ImageResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ImageShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.AttachmentEntity;

/**
 * Конвертация атрибутов Entity -> DTO
 */
public interface ImageMapper {
    ImageResponseDTO mapImageDto(AttachmentEntity attachment);

    ImageShortResponseDTO mapShortImageToDTO(AttachmentEntity attachment);
}

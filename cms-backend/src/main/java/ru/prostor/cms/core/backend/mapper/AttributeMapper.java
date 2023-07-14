package ru.prostor.cms.core.backend.mapper;

import ru.prostor.cms.core.backend.model.dto.response.AttributeResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.AttributeEntity;
import ru.prostor.cms.core.backend.model.entity.AttributeValueEntity;

import java.util.List;

/**
 * Конвертация атрибутов Entity -> DTO
 */
public interface AttributeMapper {
    AttributeResponseDTO mapAttributeToDto(AttributeEntity attribute, List<AttributeValueEntity> attributeValues);

    AttributeShortResponseDTO mapShortAttributeToDto(AttributeEntity attribute);
}

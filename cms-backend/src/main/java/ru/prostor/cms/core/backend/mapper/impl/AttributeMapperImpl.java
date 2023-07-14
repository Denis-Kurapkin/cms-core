package ru.prostor.cms.core.backend.mapper.impl;

import org.springframework.stereotype.Component;
import ru.prostor.cms.core.backend.mapper.AttributeMapper;
import ru.prostor.cms.core.backend.model.dto.response.AttributeResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeShortResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeValueResponseDTO;
import ru.prostor.cms.core.backend.model.entity.AttributeEntity;
import ru.prostor.cms.core.backend.model.entity.AttributeValueEntity;

import java.util.List;

@Component
public class AttributeMapperImpl implements AttributeMapper {
    @Override
    public AttributeResponseDTO mapAttributeToDto(AttributeEntity attribute, List<AttributeValueEntity> attributeValues) {
        return new AttributeResponseDTO(
                attribute.getAttributeId(),
                attribute.getTitle(),
                attributeValues
                        .stream()
                        .map(av -> new AttributeValueResponseDTO(av.getId(), av.getValue()))
                        .toList()
        );
    }

    @Override
    public AttributeShortResponseDTO mapShortAttributeToDto(AttributeEntity attribute) {
        return new AttributeShortResponseDTO(
                attribute.getAttributeId()
        );
    }
}

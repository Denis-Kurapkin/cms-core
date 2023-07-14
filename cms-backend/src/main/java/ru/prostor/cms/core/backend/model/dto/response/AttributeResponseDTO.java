package ru.prostor.cms.core.backend.model.dto.response;

import java.util.List;
import java.util.UUID;

public record AttributeResponseDTO(
        UUID attributeId,
        String attributeTitle,
        List<AttributeValueResponseDTO> attributeValues) {
}
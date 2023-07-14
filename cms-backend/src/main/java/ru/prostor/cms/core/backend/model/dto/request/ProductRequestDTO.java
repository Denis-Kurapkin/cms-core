package ru.prostor.cms.core.backend.model.dto.request;

import java.util.List;
import java.util.UUID;

public record ProductRequestDTO(
        UUID productId,
        UUID categoryId,
        UUID manufacturerId,
        String title,
        String article,
        double price,
        int quantity,
        boolean isActive,
        String description,
        List<AttributeValueRequestDTO> attributeValues) {
}

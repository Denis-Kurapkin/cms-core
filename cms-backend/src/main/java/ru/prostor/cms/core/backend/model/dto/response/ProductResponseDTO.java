package ru.prostor.cms.core.backend.model.dto.response;

import java.util.List;
import java.util.UUID;

public record ProductResponseDTO(
        UUID productId,
        UUID categoryId,
        UUID manufacturerId,
        String title,
        double price,
        int quantity,
        boolean isActive,
        String description,
        List<AttributeResponseDTO> attributes) {
}

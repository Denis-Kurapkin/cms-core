package ru.prostor.cms.core.backend.model.dto.response;

import java.util.Set;
import java.util.UUID;

public record CategoryResponseDTO(UUID categoryId, String categoryTitle, UUID parentCategoryId, String parentCategoryTitle,
                                  Set<UUID> filterIds) {
}

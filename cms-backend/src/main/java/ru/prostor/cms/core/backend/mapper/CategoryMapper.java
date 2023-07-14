package ru.prostor.cms.core.backend.mapper;

import ru.prostor.cms.core.backend.model.dto.response.CategoryResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.CategoryShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.CategoryEntity;

/**
 * Конвертация категорий Entity -> DTO
 */
public interface CategoryMapper {
    CategoryResponseDTO mapCategoryToDto(CategoryEntity category);

    CategoryShortResponseDTO mapShortCategoryToDTO(CategoryEntity category);
}

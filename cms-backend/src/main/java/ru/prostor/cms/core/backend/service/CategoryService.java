package ru.prostor.cms.core.backend.service;

import ru.prostor.cms.core.backend.exception.entity.CategoryNotFoundException;
import ru.prostor.cms.core.backend.model.dto.request.CategoryCreateRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.CategoryResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.CategoryShortResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Сервис получение информации о категориях.
 * <p>
 * Категория - классификация товара, например, нож, оптика, одежда
 * </p>
 */
public interface CategoryService {
    /**
     * Получение всех категорий
     */
    List<CategoryShortResponseDTO> getCategories();

    /**
     * Получение категории
     *
     * @param categoryId id категории
     * @throws CategoryNotFoundException если категория не найден
     */
    CategoryResponseDTO getCategory(UUID categoryId) throws CategoryNotFoundException;

    /**
     * Добавление новой категории
     *
     * @param categoryCreateRequestDto новые данные
     */
    void createCategory(CategoryCreateRequestDTO categoryCreateRequestDto);

    /**
     * Обновление существующей категории
     *
     * @param categoryId               id категории
     * @param categoryCreateRequestDto новые данные
     * @throws CategoryNotFoundException если категория не найден
     */
    void updateCategory(UUID categoryId, CategoryCreateRequestDTO categoryCreateRequestDto) throws CategoryNotFoundException;
}

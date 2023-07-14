package ru.prostor.cms.core.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.prostor.cms.core.backend.exception.entity.CategoryNotFoundException;
import ru.prostor.cms.core.backend.mapper.CategoryMapper;
import ru.prostor.cms.core.backend.mapper.FilterMapper;
import ru.prostor.cms.core.backend.model.dto.request.CategoryCreateRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.CategoryResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.CategoryShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.CategoryEntity;
import ru.prostor.cms.core.backend.model.type.CategoryStatus;
import ru.prostor.cms.core.backend.repository.CategoryRepository;
import ru.prostor.cms.core.backend.repository.FilterRepository;
import ru.prostor.cms.core.backend.service.CategoryService;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FilterRepository filterRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(
            CategoryRepository categoryRepository,
            FilterRepository filterRepository,
            CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.filterRepository = filterRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryShortResponseDTO> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapShortCategoryToDTO)
                .toList();
    }

    @Override
    public void createCategory(CategoryCreateRequestDTO categoryCreateRequestDto) {
        categoryRepository.save(
                new CategoryEntity(
                        categoryCreateRequestDto.title(),
                        CategoryStatus.STUB, //TODO добавить учёт статуса
                        categoryRepository.findCategoryEntityByTitle(
                                categoryCreateRequestDto.parentCategory()
                        ),
                        filterRepository.findFilterEntitiesByTitle(
                                categoryCreateRequestDto.filters()
                        )
                )
        );
    }

    @Override
    public CategoryResponseDTO getCategory(UUID categoryId) throws CategoryNotFoundException {
        return categoryMapper.mapCategoryToDto(
                categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new)
        );
    }

    @Override
    public void updateCategory(UUID id, CategoryCreateRequestDTO categoryCreateRequestDto) throws CategoryNotFoundException {
        CategoryEntity category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        category.setTitle(categoryCreateRequestDto.title());
        category.setStatus(CategoryStatus.STUB); //TODO добавить учёт статуса
        category.setParentCategory(
                categoryRepository.findCategoryEntityByTitle(
                        categoryCreateRequestDto.parentCategory()
                )
        );
        category.setFilters(
                filterRepository.findFilterEntitiesByTitle(
                        categoryCreateRequestDto.filters()
                )
        );
        categoryRepository.save(category);
    }
}

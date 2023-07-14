package ru.prostor.cms.core.backend.mapper.impl;

import org.springframework.stereotype.Component;
import ru.prostor.cms.core.backend.mapper.CategoryMapper;
import ru.prostor.cms.core.backend.model.dto.response.CategoryResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.CategoryShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.CategoryEntity;
import ru.prostor.cms.core.backend.model.entity.FilterEntity;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryResponseDTO mapCategoryToDto(CategoryEntity category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getTitle(),
                Optional.ofNullable(category.getParentCategory())
                        .map(CategoryEntity::getId)
                        .orElse(null),
                Optional.ofNullable(category.getParentCategory())
                        .map(CategoryEntity::getTitle)
                        .orElse(null),
                category.getFilters()
                        .stream()
                        .map(FilterEntity::getFilterId)
                        .collect(Collectors.toSet())
        );
    }

    @Override
    public CategoryShortResponseDTO mapShortCategoryToDTO(CategoryEntity category) {
        return new CategoryShortResponseDTO(category.getId());
    }

    //TODO не забыть, возможно пригодится
//    private List<ActiveCategoryDTO> extractActiveCategory(CategoryEntity activeCategory,
//                                                          List<CategoryEntity> categories) {
//        return categories
//                .stream()
//                .map(item -> new ActiveCategoryDTO(
//                        item.getCategoryId(),
//                        item.getTitle(),
//                        activeCategory == null
//                                ? CategoryStatus.STUB.equals(item.getStatus())
//                                : item.equals(activeCategory)
//                ))
//                .sorted((x, y) -> x.filterTitle().compareToIgnoreCase(y.filterTitle()))
//                .toList();
//    }
//
//    private List<ActiveFilterDTO> extractActiveFilters(List<AttributeEntity> activeFilters,
//                                                       List<AttributeEntity> filters) {
//        return filters
//                .stream()
//                .map(item -> new ActiveFilterDTO(
//                        item.getAttributeId(),
//                        item.getTitle(),
//                        activeFilters.contains(item)
//                ))
//                .sorted((x, y) -> x.filterTitle().compareToIgnoreCase(y.filterTitle()))
//                .toList();
//    }
//
//    private String mapCategoryTitle(CategoryEntity category) {
//        StringBuilder result = new StringBuilder(category.getTitle());
//        CategoryEntity node = category.getParentCategory();
//        while (node != null) {
//            result
//                    .append(" > ")
//                    .append(node.getTitle());
//            node = node.getParentCategory();
//        }
//        return result.toString();
//    }
}

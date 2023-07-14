package ru.prostor.cms.core.backend.service;

import ru.prostor.cms.core.backend.exception.entity.FilterNotFoundException;
import ru.prostor.cms.core.backend.model.dto.response.FilterResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.FilterShortResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Сервис получение информации о фильтрах.
 * <p>
 * Фильтр - то же самое, что атрибут товара, только используется для поиска и сортировки
 * </p>
 */
public interface FilterService {
    /**
     * Получение всех фильтров
     */
    List<FilterShortResponseDTO> getFilters();

    /**
     * Получение фильтра по id
     *
     * @param filterId id фильтра
     */
    FilterResponseDTO getFilter(UUID filterId) throws FilterNotFoundException;
}

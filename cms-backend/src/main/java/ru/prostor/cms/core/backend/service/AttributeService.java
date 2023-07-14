package ru.prostor.cms.core.backend.service;

import ru.prostor.cms.core.backend.exception.entity.AttributeNotFoundException;
import ru.prostor.cms.core.backend.model.dto.request.AttributeRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeShortResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Сервис получение информации об атрибутах.
 * <p>
 * Атрибут - отличительное свойство товара, например, вес, размер, цвет, и т.п.
 * </p>
 */
public interface AttributeService {
    /**
     * Получение всех атрибутов
     */
    List<AttributeShortResponseDTO> getAttributes();

    /**
     * Получение атрибута товара
     *
     * @param attributeId filterId атрибута
     * @throws AttributeNotFoundException если атрибут не найден
     */
    AttributeResponseDTO getAttribute(UUID attributeId) throws AttributeNotFoundException;

    /**
     * Обновление существующего атрибута
     *
     * @param attributeId         filterId атрибута
     * @param attributeRequestDto новые данные
     * @throws AttributeNotFoundException если атрибут не найден
     */
    void updateAttribute(UUID attributeId, AttributeRequestDTO attributeRequestDto) throws AttributeNotFoundException;

    /**
     * Добавление нового атрибута
     *
     * @param attributeRequestDto новые данные
     */
    void createAttribute(AttributeRequestDTO attributeRequestDto);
}

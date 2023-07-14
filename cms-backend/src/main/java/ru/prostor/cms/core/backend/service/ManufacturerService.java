package ru.prostor.cms.core.backend.service;

import ru.prostor.cms.core.backend.exception.entity.ManufacturerNotFoundException;
import ru.prostor.cms.core.backend.model.dto.request.ManufacturerCreateDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerShortResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Сервис получения информации о производителях
 */
public interface ManufacturerService {
    /**
     * Получение всех производителей
     */
    List<ManufacturerShortResponseDTO> getManufactures();

    /**
     * Добавление производителя
     */
    void addManufacturer(ManufacturerCreateDTO manufacturerCreateDTO);

    /**
     * Получение производителя
     */
    ManufacturerResponseDTO getManufacturer(UUID manufactureId) throws ManufacturerNotFoundException;

    /**
     * Обновление производителя
     */
    void updateManufacturer(UUID manufactureId, ManufacturerCreateDTO manufacturerCreateDTO) throws ManufacturerNotFoundException;
}

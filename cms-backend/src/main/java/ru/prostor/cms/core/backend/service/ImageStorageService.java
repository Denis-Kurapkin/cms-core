package ru.prostor.cms.core.backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import ru.prostor.cms.core.backend.model.dto.response.ImageResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ImageShortResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс загрузки изображений
 */
public interface ImageStorageService {
    /**
     * Получение списка URL изображений
     */
    List<ImageShortResponseDTO> getImageNames();

    /**
     * Получение файла изображения
     *
     * @param imageId id изображения
     */
    Resource getImage(UUID imageId);

    /**
     * Загрузка изображений на сервер
     *
     * @param images ресурс изображений
     */
    void uploadImages(List<MultipartFile> images);

    /**
     * Удаление изображений с сервера
     *
     * @param imageIds список id
     */
    void deleteImages(List<UUID> imageIds);
}

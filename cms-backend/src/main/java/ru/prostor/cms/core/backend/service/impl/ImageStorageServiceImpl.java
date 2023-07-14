package ru.prostor.cms.core.backend.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.prostor.cms.core.backend.config.property.ImgStorageProperty;
import ru.prostor.cms.core.backend.exception.StorageException;
import ru.prostor.cms.core.backend.exception.StorageFileNotFoundException;
import ru.prostor.cms.core.backend.exception.entity.AttachmentNotFoundException;
import ru.prostor.cms.core.backend.mapper.ImageMapper;
import ru.prostor.cms.core.backend.model.dto.response.ImageResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ImageShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.AttachmentEntity;
import ru.prostor.cms.core.backend.repository.AttachmentRepository;
import ru.prostor.cms.core.backend.service.ImageStorageService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ImageStorageServiceImpl implements ImageStorageService {
    private final Path location;
    private final AttachmentRepository attachmentRepository;
    private final ImageMapper imageMapper;

    public ImageStorageServiceImpl(
            ImgStorageProperty properties,
            AttachmentRepository attachmentRepository,
            ImageMapper imageMapper) {
        this.location = Paths.get(properties.getUrl());
        this.attachmentRepository = attachmentRepository;
        this.imageMapper = imageMapper;

        if (!Files.exists(location)) { //TODO
            try {
                Files.createDirectory(location);
            } catch (IOException e) {
                throw new StorageException("Could not initialize storage", e);
            }
        }
    }

    @Override
    public List<ImageShortResponseDTO> getImageNames() {
        return attachmentRepository.findAll()
                .stream()
                .map(imageMapper::mapShortImageToDTO)
                .toList();
    }

    @Override
    public Resource getImage(UUID imageId) {
        String imageUrl = attachmentRepository.findById(imageId)
                .orElseThrow(AttachmentNotFoundException::new)
                .getAttachmentTitle();
        try {
            Path file = location.resolve(imageUrl);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + imageUrl); //TODO

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + imageUrl, e); //TODO
        }
    }

    @Override
    public void uploadImages(List<MultipartFile> images) {
        for (MultipartFile file : images) {
            attachmentRepository.save(
                    new AttachmentEntity(
                            file.getOriginalFilename(),
                            this.location.toString(),
                            file.getContentType()
                    )
            );
            try {
                Files.copy(file.getInputStream(), this.location.resolve(file.getOriginalFilename()));
            } catch (IOException e) {
                throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
            }
        }
    }

    @Override
    public void deleteImages(List<UUID> imageIds) {
        attachmentRepository.findAllById(imageIds)
                .forEach(
                        image -> {
                            Path path = Paths.get(String.join("\\", location.toString(), image.getAttachmentTitle()));
                            try {
                                Files.delete(path);
                            } catch (IOException e) {
                                throw new RuntimeException(e); //TODO
                            }
                        }
                );
        attachmentRepository.deleteAllById(imageIds);
    }
}

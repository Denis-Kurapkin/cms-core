package ru.prostor.cms.core.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.prostor.cms.core.backend.model.dto.response.ImageResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ImageShortResponseDTO;
import ru.prostor.cms.core.backend.service.ImageStorageService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/files")
@Tag(name = "Изображения")
public class ImageController {
    private final ImageStorageService imageStorageService;

    public ImageController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @Operation(summary = "Получить список файлов")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ImageShortResponseDTO> getImageNames() {
        return imageStorageService.getImageNames();
    }

    @Operation(summary = "Получить конкретный файл")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(value = "/{imageId}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Resource> getImage(@PathVariable("imageId") UUID imageId) {
        Resource file = imageStorageService.getImage(imageId);
        return ResponseEntity.ok().body(file);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void uploadImages(@RequestPart("files") @NotEmpty List<MultipartFile> images) {
        imageStorageService.uploadImages(images);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImages(@RequestBody List<UUID> imageIds) {
        imageStorageService.deleteImages(imageIds);
    }
}
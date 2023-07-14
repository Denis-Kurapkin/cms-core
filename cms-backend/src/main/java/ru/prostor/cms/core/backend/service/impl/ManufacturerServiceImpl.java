package ru.prostor.cms.core.backend.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.prostor.cms.core.backend.exception.entity.ManufacturerNotFoundException;
import ru.prostor.cms.core.backend.mapper.ManufactureMapper;
import ru.prostor.cms.core.backend.model.dto.request.ImageCreateRequestDTO;
import ru.prostor.cms.core.backend.model.dto.request.ManufacturerCreateDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.ManufacturerEntity;
import ru.prostor.cms.core.backend.model.entity.ManufacturerJAttachmentEntity;
import ru.prostor.cms.core.backend.repository.ManufactureRepository;
import ru.prostor.cms.core.backend.repository.ManufacturerJAttachmentRepository;
import ru.prostor.cms.core.backend.service.ManufacturerService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufactureRepository manufactureRepository;
    private final ManufacturerJAttachmentRepository manufacturerJAttachmentRepository;
    private final ManufactureMapper manufactureMapper;

    public ManufacturerServiceImpl(
            ManufactureRepository manufactureRepository,
            ManufacturerJAttachmentRepository manufacturerJAttachmentRepository,
            ManufactureMapper manufactureMapper) {
        this.manufactureRepository = manufactureRepository;
        this.manufacturerJAttachmentRepository = manufacturerJAttachmentRepository;
        this.manufactureMapper = manufactureMapper;
    }

    @Override
    public List<ManufacturerShortResponseDTO> getManufactures() {
        return manufactureRepository.findAll()
                .stream()
                .map(manufactureMapper::mapShortManufacturerToDTO)
                .toList();
    }

    @Override
    @Transactional
    public void addManufacturer(ManufacturerCreateDTO manufacturerCreateDTO) {
        ManufacturerEntity manufacturer = manufactureRepository.save(
                new ManufacturerEntity(
                        manufacturerCreateDTO.manufactureTitle()
                )
        );
        manufacturer.setManufacturerJAttachments(
                mergeManufacturerJAttachments(manufacturer, manufacturerCreateDTO.imageCreateDTO())
        );
        manufactureRepository.save(manufacturer);
    }

    @Override
    public ManufacturerResponseDTO getManufacturer(UUID manufactureId) throws ManufacturerNotFoundException {
        return manufactureRepository.findById(manufactureId)
                .map(manufactureMapper::mapManufactureToDto)
                .orElseThrow(ManufacturerNotFoundException::new);
    }

    @Override
    @Transactional
    public void updateManufacturer(UUID manufactureId, ManufacturerCreateDTO manufacturerCreateDTO) throws ManufacturerNotFoundException {
        ManufacturerEntity manufacturer = manufactureRepository.findById(manufactureId)
                .orElseThrow(ManufacturerNotFoundException::new);
        manufacturer.setTitle(manufacturerCreateDTO.manufactureTitle());
        manufacturer.setManufacturerJAttachments(
                mergeManufacturerJAttachments(manufacturer, manufacturerCreateDTO.imageCreateDTO())
        );
        manufactureRepository.saveAndFlush(manufacturer);
    }

    private List<ManufacturerJAttachmentEntity> mergeManufacturerJAttachments(
            ManufacturerEntity manufacturer,
            Set<ImageCreateRequestDTO> imageDTO) {
        List<ManufacturerJAttachmentEntity> createEntities = imageDTO
                .stream()
                .map(i -> new ManufacturerJAttachmentEntity(manufacturer.getId(), i.imageId(), i.sort()))
                .toList();
        manufacturerJAttachmentRepository.deleteAll(manufacturer.getManufacturerJAttachments());
        return manufacturerJAttachmentRepository.saveAll(createEntities);
    }
}

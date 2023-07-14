package ru.prostor.cms.core.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.prostor.cms.core.backend.exception.entity.AttributeNotFoundException;
import ru.prostor.cms.core.backend.mapper.AttributeMapper;
import ru.prostor.cms.core.backend.model.dto.request.AttributeRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.AttributeEntity;
import ru.prostor.cms.core.backend.model.entity.AttributeValueEntity;
import ru.prostor.cms.core.backend.repository.AttributeRepository;
import ru.prostor.cms.core.backend.repository.AttributeValueRepository;
import ru.prostor.cms.core.backend.service.AttributeService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImpl implements AttributeService {
    private final AttributeMapper attributeMapper;
    private final AttributeRepository attributeRepository;
    private final AttributeValueRepository attributeValueRepository;

    public AttributeServiceImpl(
            AttributeMapper attributeMapper,
            AttributeRepository attributeRepository,
            AttributeValueRepository attributeValueRepository) {
        this.attributeMapper = attributeMapper;
        this.attributeRepository = attributeRepository;
        this.attributeValueRepository = attributeValueRepository;
    }

    @Override
    public List<AttributeShortResponseDTO> getAttributes() {
        return attributeRepository.findAll()
                .stream()
                .map(attributeMapper::mapShortAttributeToDto)
                .toList();
    }

    @Override
    public AttributeResponseDTO getAttribute(UUID attributeId) throws AttributeNotFoundException {
        AttributeEntity attribute = attributeRepository
                .findById(attributeId)
                .orElseThrow(AttributeNotFoundException::new);
        return attributeMapper.mapAttributeToDto(attribute, attribute.getAttributeValues());
    }

    @Override
    public void updateAttribute(UUID attributeId, AttributeRequestDTO attributeRequestDto) throws AttributeNotFoundException {
        AttributeEntity attribute = attributeRepository.findById(attributeId)
                .orElseThrow(AttributeNotFoundException::new);
        attribute.setTitle(attributeRequestDto.attributeTitle());
        Map<String, AttributeValueEntity> attributeValues = attribute.getAttributeValues()
                .stream()
                .collect(
                        Collectors.toMap(
                                AttributeValueEntity::getValue,
                                Function.identity()
                        )
                );
        attributeValues
                .entrySet()
                .stream()
                .filter(av -> !attributeRequestDto.attributeValues().contains(av.getKey()))
                .forEach(av -> attributeValueRepository.delete(av.getValue()));
        attributeRequestDto
                .attributeValues()
                .stream()
                .filter(av -> !attributeValues.containsKey(av))
                .map(av -> new AttributeValueEntity(av, attribute))
                .forEach(attributeValueRepository::save);
        attributeRepository.save(attribute);
    }

    @Override
    public void createAttribute(AttributeRequestDTO attributeRequestDto) { //TODO при доабвлении атрибута также добавлять фильтр
        AttributeEntity a = attributeRepository.save(new AttributeEntity(attributeRequestDto.attributeTitle()));
        attributeRequestDto.attributeValues()
                .stream()
                .map(av -> new AttributeValueEntity(av, a))
                .forEach(attributeValueRepository::save);
    }
}

package ru.prostor.cms.core.backend.mapper.impl;

import org.springframework.stereotype.Component;
import ru.prostor.cms.core.backend.mapper.AttributeMapper;
import ru.prostor.cms.core.backend.mapper.ProductMapper;
import ru.prostor.cms.core.backend.model.dto.response.AttributeResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ProductResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ProductShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.AttributeValueEntity;
import ru.prostor.cms.core.backend.model.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductMapperImpl implements ProductMapper {

    private final AttributeMapper attributeMapper;

    public ProductMapperImpl(AttributeMapper attributeMapper) {
        this.attributeMapper = attributeMapper;
    }

    @Override
    public ProductShortResponseDTO mapProductsToDTO(ProductEntity productEntity) {
        return new ProductShortResponseDTO(productEntity.getProductId());
    }

    @Override
    public ProductResponseDTO mapProductToDTO(ProductEntity productEntity) {
        List<AttributeResponseDTO> attributeResponseDTOS = productEntity.getAttributeValues()
                .stream()
                .collect(Collectors.groupingBy(AttributeValueEntity::getAttribute))
                .entrySet()
                .stream()
                .map(x -> attributeMapper.mapAttributeToDto(x.getKey(), x.getValue()))
                .toList();
        return new ProductResponseDTO(
                productEntity.getProductId(),
                productEntity.getCategory().getId(),
                productEntity.getManufacturer().getId(),
                productEntity.getTitle(),
                productEntity.getPrice(),
                productEntity.getQuantity(),
                productEntity.isActive(),
                productEntity.getDescription(),
                attributeResponseDTOS
        );
    }
}

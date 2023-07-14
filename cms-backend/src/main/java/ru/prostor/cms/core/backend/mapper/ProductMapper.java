package ru.prostor.cms.core.backend.mapper;

import ru.prostor.cms.core.backend.model.dto.response.ProductResponseDTO;
import ru.prostor.cms.core.backend.model.entity.ProductEntity;
import ru.prostor.cms.core.backend.model.dto.response.ProductShortResponseDTO;

public interface ProductMapper {

    ProductShortResponseDTO mapProductsToDTO(ProductEntity productEntity);

    ProductResponseDTO mapProductToDTO(ProductEntity productEntity);
}

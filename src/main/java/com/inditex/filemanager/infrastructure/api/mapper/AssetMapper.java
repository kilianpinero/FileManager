package com.inditex.filemanager.infrastructure.api.mapper;

import com.inditex.filemanager.domain.model.Asset;
import com.inditex.filemanager.infrastructure.persistence.entity.AssetEntity;
import org.mapstruct.Mapper;

import java.time.ZonedDateTime;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface AssetMapper {
    Asset toModel(AssetEntity entity);

    default String map(ZonedDateTime uploadDate) {
        return Objects.nonNull(uploadDate) ? uploadDate.toOffsetDateTime().toString() : null;
    }

}
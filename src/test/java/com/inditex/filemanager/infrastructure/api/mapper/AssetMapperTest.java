package com.inditex.filemanager.infrastructure.api.mapper;

import com.inditex.filemanager.domain.model.Asset;
import com.inditex.filemanager.infrastructure.persistence.entity.AssetEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.CONTENT_TYPE;
import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.EXAMPLE_PDF;
import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.SIZE;
import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.UPLOAD_DATE;
import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.URL;
import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.buildAssetEntityWithId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AssetMapperTest {

    @Autowired
    private AssetMapper mapper;

    @Test
    void shouldMapAssetEntityToAsset() {
        // Given
        AssetEntity entity = buildAssetEntityWithId();

        // When
        Asset result = mapper.toModel(entity);

        // Then
        assertNotNull(result);
        assertEquals(String.valueOf(1L), result.getId());
        assertEquals(UPLOAD_DATE.toOffsetDateTime().toString(), result.getUploadDate());
        assertEquals(EXAMPLE_PDF, result.getFilename());
        assertEquals(CONTENT_TYPE, result.getContentType());
        assertEquals(URL, result.getUrl());
        assertEquals(SIZE, result.getSize());
    }
}
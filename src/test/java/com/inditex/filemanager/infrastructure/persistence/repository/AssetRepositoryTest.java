package com.inditex.filemanager.infrastructure.persistence.repository;

import com.inditex.filemanager.infrastructure.persistence.entity.AssetEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.CONTENT_TYPE;
import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.EXAMPLE_PDF;
import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.buildAssetEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AssetRepositoryTest {



    @Autowired
    AssetRepository assetRepository;

    @Test
    void when_saveAsset_then_returnAsset() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.of(2023,
                5, 9, 14, 30, 0, 0, ZoneId.of("Europe/Madrid"));
        ZonedDateTime endDate = ZonedDateTime.of(2023,
                5, 11, 14, 30, 0, 0, ZoneId.of("Europe/Madrid"));
        AssetEntity asset = buildAssetEntity();

        // when
        assetRepository.save(asset);

        List<AssetEntity> result = assetRepository.findByFilters(
                startDate,
                endDate,
                EXAMPLE_PDF,
                CONTENT_TYPE
        );
        // then
        assertEquals(1, result.size());
        assertEquals(EXAMPLE_PDF, result.getFirst().getFilename());
    }
}
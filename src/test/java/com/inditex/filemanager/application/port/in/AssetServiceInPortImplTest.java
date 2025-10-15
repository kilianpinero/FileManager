package com.inditex.filemanager.application.port.in;

import com.inditex.filemanager.domain.model.Asset;
import com.inditex.filemanager.infrastructure.api.mapper.AssetMapper;
import com.inditex.filemanager.infrastructure.persistence.entity.AssetEntity;
import com.inditex.filemanager.infrastructure.persistence.repository.AssetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.inditex.filemanager.builders.entity.AssetEntityBuilder.buildAssetEntityWithParams;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssetServiceInPortImplTest {

    public static final String INVOICE_OCT_PDF = "invoice_oct.pdf";
    public static final String INVOICE_SEP_PDF = "invoice_sep.pdf";
    public static final String CONTENT_TYPE = "application/pdf";
    @Mock
    private AssetRepository assetRepository;

    @Mock
    private AssetMapper assetMapper;

    @InjectMocks
    private AssetServiceInPortImpl service;

    @Test
    void when_getAssetsByFilter_then_returnAssetsList() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.of(2025,
                10, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime endDate = ZonedDateTime.of(2025,
                10, 15, 0, 0, 0, 0, ZoneId.systemDefault());
        String start = startDate.toOffsetDateTime().toString();
        String end = endDate.toOffsetDateTime().toString();
        String filename = "invoice";
        String filetype = "pdf";
        String sortDirection = "asc";

        AssetEntity entity1 = buildAssetEntityWithParams(1L, INVOICE_OCT_PDF, CONTENT_TYPE, startDate);
        AssetEntity entity2 = buildAssetEntityWithParams(2L, INVOICE_SEP_PDF, CONTENT_TYPE, endDate);

        Asset asset1 = new Asset().id("1").filename(INVOICE_OCT_PDF);
        Asset asset2 = new Asset().id("2").filename(INVOICE_SEP_PDF);

        List<AssetEntity> entities = new ArrayList<>(List.of(entity1, entity2));
        when(assetRepository.findByFilters(any(), any(), eq(filename), eq(filetype))).thenReturn(entities);
        when(assetMapper.toModel(entity1)).thenReturn(asset1);
        when(assetMapper.toModel(entity2)).thenReturn(asset2);

        // When
        List<Asset> result = service.getAssetsByFilter(start, end, filename, filetype, sortDirection);

        // Then
        assertThat(result).containsExactly(asset1, asset2);
        verify(assetRepository).findByFilters(any(), any(), eq(filename), eq(filetype));
        verify(assetMapper).toModel(entity1);
        verify(assetMapper).toModel(entity2);
    }
}
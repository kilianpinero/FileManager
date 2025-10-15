package com.inditex.filemanager.application.port.in;

import com.inditex.filemanager.domain.model.Asset;
import com.inditex.filemanager.domain.model.AssetFileUploadRequest;
import com.inditex.filemanager.infrastructure.api.mapper.AssetMapper;
import com.inditex.filemanager.infrastructure.persistence.entity.AssetEntity;
import com.inditex.filemanager.infrastructure.persistence.repository.AssetRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class AssetServiceInPortImpl implements AssetServiceInPort{

    public static final String ASC = "asc";
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private AssetMapper assetMapper;

    @Override
    public List<Asset> getAssetsByFilter(String uploadDateStart, String uploadDateEnd, String filename, String filetype, String sortDirection) {
        ZonedDateTime startDate = ZonedDateTime.parse(uploadDateStart);
        ZonedDateTime endDate = ZonedDateTime.parse(uploadDateEnd);

        List<AssetEntity> entities = assetRepository.findByFilters(startDate, endDate, filename, filetype);

        if (Objects.nonNull(entities) && !entities.isEmpty()) {
            sortAssetEntities(entities, sortDirection);
        }

        return entities.stream()
                .map(assetMapper::toModel)
                .collect(Collectors.toList());
    }


    @Async
    @Override
    public CompletableFuture<Asset> uploadAssetAsync(AssetFileUploadRequest request) {
        String externalUrl = fakeProxyUploadToExternalSystem(request.getEncodedFile(), request.getFilename());

        AssetEntity assetEntity = AssetEntity.builder()
                .filename(request.getFilename())
                .contentType(request.getContentType())
                .size(Objects.nonNull(request.getEncodedFile()) ? request.getEncodedFile().length : 0)
                .uploadDate(ZonedDateTime.now().withNano(0))
                .url(externalUrl)
                .build();

        AssetEntity savedAsset = assetRepository.save(assetEntity);
        return CompletableFuture.completedFuture(assetMapper.toModel(savedAsset));
    }

    private void sortAssetEntities(List<AssetEntity> entities, String sortDirection) {
        if (Objects.nonNull(sortDirection)) {
            String trimmedDirection = sortDirection.trim();
            entities.sort(Comparator.comparing(AssetEntity::getUploadDate).reversed());
            if (ASC.equalsIgnoreCase(trimmedDirection)) {
                entities.sort(Comparator.comparing(AssetEntity::getUploadDate));
            }
        }
    }

    @CircuitBreaker(name = "externalUpload", fallbackMethod = "fallbackUpload")
    private String fakeProxyUploadToExternalSystem(byte[] file, String filename) {
        return "https://inditex-external-storage.com/" + filename;
    }

    private String fallbackUpload(byte[] file, String filename, Throwable t) {
        return "https://inditex-backup-storage.com/" + filename;
    }


}

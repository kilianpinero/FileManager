package com.inditex.filemanager.application.port.in;

import com.inditex.filemanager.domain.model.Asset;
import com.inditex.filemanager.domain.model.AssetFileUploadRequest;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AssetServiceInPort {
    List<Asset> getAssetsByFilter(String uploadDateStart,
                                  String uploadDateEnd,
                                  String filename,
                                  String filetype,
                                  String sortDirection);

    @Async
    CompletableFuture<Asset> uploadAssetAsync(AssetFileUploadRequest request);
}

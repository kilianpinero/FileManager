package com.inditex.filemanager.infrastructure.api.controllers;

import com.inditex.filemanager.application.port.in.AssetServiceInPort;
import com.inditex.filemanager.domain.model.Asset;
import com.inditex.filemanager.domain.model.AssetFileUploadRequest;
import com.inditex.filemanager.domain.model.AssetFileUploadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AssetController implements ApiApi {

    @Autowired
    private AssetServiceInPort assetServiceInPort;

    @Override
    public ResponseEntity<AssetFileUploadResponse> uploadAssetFile(AssetFileUploadRequest assetFileUploadRequest) {
        assetServiceInPort.uploadAssetAsync(assetFileUploadRequest);
        AssetFileUploadResponse response = new AssetFileUploadResponse().id("processing");
        return ResponseEntity.accepted().body(response);
    }

    @Override
    public ResponseEntity<List<Asset>> getAssetsByFilter(
            String uploadDateStart,
            String uploadDateEnd,
            String filename,
            String filetype,
            String sortDirection
    ) {
        List<Asset> assets = assetServiceInPort.getAssetsByFilter(
                uploadDateStart,
                uploadDateEnd,
                filename,
                filetype,
                sortDirection
        );
        return ResponseEntity.ok(assets);
    }

}
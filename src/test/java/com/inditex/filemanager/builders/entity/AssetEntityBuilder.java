package com.inditex.filemanager.builders.entity;

import com.inditex.filemanager.infrastructure.persistence.entity.AssetEntity;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AssetEntityBuilder {

    public static final String EXAMPLE_PDF = "example.pdf";
    public static final String CONTENT_TYPE = "application/pdf";
    public static final String URL = "http://localhost/files/1";
    public static final int SIZE = 1234;
    public static final ZonedDateTime UPLOAD_DATE = ZonedDateTime.of(2023,
            5, 10, 14, 30, 0, 0, ZoneId.of("Europe/Madrid"));


    public static AssetEntity buildAssetEntity() {
        return AssetEntity.builder()
                .filename(EXAMPLE_PDF)
                .contentType(CONTENT_TYPE)
                .url(URL)
                .size(SIZE)
                .uploadDate(UPLOAD_DATE)
                .build();
    }

    public static AssetEntity buildAssetEntityWithId() {
        return AssetEntity.builder()
                .id(1L)
                .filename(EXAMPLE_PDF)
                .contentType(CONTENT_TYPE)
                .url(URL)
                .size(SIZE)
                .uploadDate(UPLOAD_DATE)
                .build();
    }

    public static AssetEntity buildAssetEntityWithParams(Long id,
                                                         String filename,
                                                         String contentType,
                                                         ZonedDateTime uploadDate) {
        return AssetEntity.builder()
                .id(id)
                .filename(filename)
                .contentType(contentType)
                .uploadDate(uploadDate)
                .build();
    }


}

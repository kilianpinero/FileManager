package com.inditex.filemanager.infrastructure.api.mapper;

import com.inditex.filemanager.domain.model.Asset;
import com.inditex.filemanager.infrastructure.persistence.entity.AssetEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-15T00:10:11+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21 (Oracle Corporation)"
)
@Component
public class AssetMapperImpl implements AssetMapper {

    @Override
    public Asset toModel(AssetEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Asset asset = new Asset();

        if ( entity.getId() != null ) {
            asset.setId( String.valueOf( entity.getId() ) );
        }
        asset.setFilename( entity.getFilename() );
        asset.setContentType( entity.getContentType() );
        asset.setUrl( entity.getUrl() );
        asset.setSize( entity.getSize() );
        asset.setUploadDate( map( entity.getUploadDate() ) );

        return asset;
    }
}

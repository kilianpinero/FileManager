package com.inditex.filemanager.infrastructure.persistence.repository;

import com.inditex.filemanager.infrastructure.persistence.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, Long> {

    @Query("SELECT a FROM AssetEntity a " +
            "WHERE (:filename IS NULL OR a.filename LIKE %:filename%) " +
            "AND (:filetype IS NULL OR a.contentType LIKE %:filetype%) " +
            "AND (:uploadDateStart IS NULL OR a.uploadDate >= :uploadDateStart) " +
            "AND (:uploadDateEnd IS NULL OR a.uploadDate <= :uploadDateEnd)")
    List<AssetEntity> findByFilters(
            @Param("uploadDateStart") ZonedDateTime uploadDateStart,
            @Param("uploadDateEnd") ZonedDateTime uploadDateEnd,
            @Param("filename") String filename,
            @Param("filetype") String filetype
    );
}
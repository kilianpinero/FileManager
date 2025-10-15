package com.inditex.filemanager.domain.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Represents an asset.
 */

@Schema(name = "Asset", description = "Represents an asset.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-14T15:54:06.194378300+02:00[Europe/Madrid]", comments = "Generator version: 7.16.0")
public class Asset {

  private @Nullable String id;

  private @Nullable String filename;

  private @Nullable String contentType;

  private @Nullable String url;

  private @Nullable Integer size;

  private @Nullable String uploadDate;

  public Asset id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique file identifier.
   * @return id
   */
  
  @Schema(name = "id", description = "Unique file identifier.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  public void setId(@Nullable String id) {
    this.id = id;
  }

  public Asset filename(@Nullable String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * Name of the asset.
   * @return filename
   */
  
  @Schema(name = "filename", description = "Name of the asset.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filename")
  public @Nullable String getFilename() {
    return filename;
  }

  public void setFilename(@Nullable String filename) {
    this.filename = filename;
  }

  public Asset contentType(@Nullable String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * The file type.
   * @return contentType
   */
  
  @Schema(name = "contentType", description = "The file type.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contentType")
  public @Nullable String getContentType() {
    return contentType;
  }

  public void setContentType(@Nullable String contentType) {
    this.contentType = contentType;
  }

  public Asset url(@Nullable String url) {
    this.url = url;
    return this;
  }

  /**
   * The URL of the uploaded/published asset.
   * @return url
   */
  
  @Schema(name = "url", description = "The URL of the uploaded/published asset.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("url")
  public @Nullable String getUrl() {
    return url;
  }

  public void setUrl(@Nullable String url) {
    this.url = url;
  }

  public Asset size(@Nullable Integer size) {
    this.size = size;
    return this;
  }

  /**
   * The actual file size.
   * @return size
   */
  
  @Schema(name = "size", description = "The actual file size.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public @Nullable Integer getSize() {
    return size;
  }

  public void setSize(@Nullable Integer size) {
    this.size = size;
  }

  public Asset uploadDate(@Nullable String uploadDate) {
    this.uploadDate = uploadDate;
    return this;
  }

  /**
   * The date & time the file was uploaded.
   * @return uploadDate
   */
  
  @Schema(name = "uploadDate", description = "The date & time the file was uploaded.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uploadDate")
  public @Nullable String getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(@Nullable String uploadDate) {
    this.uploadDate = uploadDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Asset asset = (Asset) o;
    return Objects.equals(this.id, asset.id) &&
        Objects.equals(this.filename, asset.filename) &&
        Objects.equals(this.contentType, asset.contentType) &&
        Objects.equals(this.url, asset.url) &&
        Objects.equals(this.size, asset.size) &&
        Objects.equals(this.uploadDate, asset.uploadDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, filename, contentType, url, size, uploadDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Asset {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    uploadDate: ").append(toIndentedString(uploadDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


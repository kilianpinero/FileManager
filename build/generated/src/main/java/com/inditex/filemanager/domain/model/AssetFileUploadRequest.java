package com.inditex.filemanager.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a file upload request.
 */

@Schema(name = "AssetFileUploadRequest", description = "Represents a file upload request.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-14T15:54:06.194378300+02:00[Europe/Madrid]", comments = "Generator version: 7.16.0")
public class AssetFileUploadRequest {

  private @Nullable String filename;

  private @Nullable byte[] encodedFile;

  private @Nullable String contentType;

  public AssetFileUploadRequest filename(@Nullable String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * The filename associated to the asset being uploaded.
   * @return filename
   */
  
  @Schema(name = "filename", example = "img.png", description = "The filename associated to the asset being uploaded.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filename")
  public @Nullable String getFilename() {
    return filename;
  }

  public void setFilename(@Nullable String filename) {
    this.filename = filename;
  }

  public AssetFileUploadRequest encodedFile(@Nullable byte[] encodedFile) {
    this.encodedFile = encodedFile;
    return this;
  }

  /**
   * The actual file to be uploaded.
   * @return encodedFile
   */
  
  @Schema(name = "encodedFile", description = "The actual file to be uploaded.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("encodedFile")
  public @Nullable byte[] getEncodedFile() {
    return encodedFile;
  }

  public void setEncodedFile(@Nullable byte[] encodedFile) {
    this.encodedFile = encodedFile;
  }

  public AssetFileUploadRequest contentType(@Nullable String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * The filetype according to the MIME type (IANA) definition.
   * @return contentType
   */
  
  @Schema(name = "contentType", description = "The filetype according to the MIME type (IANA) definition.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contentType")
  public @Nullable String getContentType() {
    return contentType;
  }

  public void setContentType(@Nullable String contentType) {
    this.contentType = contentType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetFileUploadRequest assetFileUploadRequest = (AssetFileUploadRequest) o;
    return Objects.equals(this.filename, assetFileUploadRequest.filename) &&
        Arrays.equals(this.encodedFile, assetFileUploadRequest.encodedFile) &&
        Objects.equals(this.contentType, assetFileUploadRequest.contentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filename, Arrays.hashCode(encodedFile), contentType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetFileUploadRequest {\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    encodedFile: ").append(toIndentedString(encodedFile)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
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


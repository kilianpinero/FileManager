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
 * Represents a file upload response.
 */

@Schema(name = "AssetFileUploadResponse", description = "Represents a file upload response.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-14T15:54:06.194378300+02:00[Europe/Madrid]", comments = "Generator version: 7.16.0")
public class AssetFileUploadResponse {

  private @Nullable String id;

  public AssetFileUploadResponse id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the requested file upload.
   * @return id
   */
  
  @Schema(name = "id", description = "Unique identifier for the requested file upload.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  public void setId(@Nullable String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetFileUploadResponse assetFileUploadResponse = (AssetFileUploadResponse) o;
    return Objects.equals(this.id, assetFileUploadResponse.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetFileUploadResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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


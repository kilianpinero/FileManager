# FileManager API

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
    - [Upload Asset File](#upload-asset-file)
    - [List & Filter Assets](#list--filter-assets)
- [Configuration](#configuration-1)
    - [MySQL Setup with Docker](#mysql-setup-with-docker)
- [Security](#security)
- [Postman Collection](#postman)
- [Possible Improvements](#possible-improvements)


A Spring Boot REST API for managing file assets. Supports file upload, asset listing, and filtering.

## Features

- Upload files with metadata
- List and filter assets by date, filename, type, and sort direction
- MySQL database integration
- OpenAPI documentation

## Tech Stack

- Java 21
- Spring Boot
- Gradle
- MySQL
- MapStruct
- Swagger/OpenAPI

## Getting Started

### Prerequisites

- Java 21+
- MySQL (default port: 3326)
- Gradle

### Configuration


## API Endpoints

### Upload Asset File

#### POST /api/mgmt/1/assets/actions/upload

Request Body Example:

```
{
    "filename": "example.pdf",
    "encodedFile": "VGhpcyBpcyBhIHNhbXBsZSBmaWxlIGNvbnRlbnQ=",
    "contentType": "application/pdf"
}
```
Response Example:
```
{
    "id": "a1b2c3d4"
}
```

### List & Filter Assets

#### GET /api/mgmt/1/assets/

Query Parameters:
- uploadDateStart (e.g., 2025-01-01T00:00:00Z)
- uploadDateEnd (e.g., 2025-12-31T23:59:59Z)
- filename (e.g., example.pdf)
- filetype (e.g., application/pdf)
- sortDirection (asc or desc)

Response Example:
```
[
    {
        "id": "a1b2c3d4",
        "filename": "example.pdf",
        "contentType": "application/pdf",
        "url": "http://localhost:9090/files/a1b2c3d4",
        "size": 123456,
        "uploadDate": "2025-10-14T15:54:06Z"
    }
]
```

## Configuration

### MySQL Setup with Docker

To run MySQL using Docker, execute the following command in your project directory (where the Dockerfile or docker-compose.yml is located):

```
docker build -t filemanager-mysql-db -f Dockerfile.mysql .
docker run -d --name filemanager-mysql-db -p 3326:3306 filemanager-mysql-db
```

The database will be available at localhost:3326.
Update application.yml if you change the port or credentials.

## Security

The API uses HTTP Basic authentication for protected endpoints.

Protected endpoint:
- POST /api/mgmt/1/assets/actions/upload --> requires authentication.

Default credentials (for development):
- Username: user
- Password: password
Include the credentials in your request using HTTP Basic Auth.

### Circuit Breaker
The application uses a Circuit Breaker pattern (implemented with Resilience4j) to improve fault tolerance and reliability.
It automatically detects failures in external dependencies (such as the database or file storage) and temporarily blocks requests to prevent cascading errors.
Configuration can be adjusted in application.yml under the resilience4j.circuitbreaker section.


## Postman

There is a collection available located in /src/main/resources to test all endpoints configured with Basic Auth, parameters and request body.

## Possible Improvements
- Use DTOs for requests and responses to decouple domain and API models.
- Add validation annotations to request DTOs.
- Use meaningful HTTP status codes and error handling (@ControllerAdvice).

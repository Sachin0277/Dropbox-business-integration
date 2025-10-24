# Dropbox Business Integration

This is a Spring Boot project to fetch Dropbox Business team members using admin access token and client credentials. The project uses the Dropbox API v2 and Spring `RestTemplate` to interact with Dropbox endpoints.

---

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [How to Run](#how-to-run)
- [Endpoints](#endpoints)
- [Troubleshooting](#troubleshooting)
- [Dependencies](#dependencies)

---

## Features

- Generate OAuth 2 access token using client credentials
- Fetch all team members from Dropbox Business account
- Simple REST API endpoint using Spring Boot
- No refresh token required

---

## Prerequisites

- Java 17 or higher
- Maven 3.8+
- Dropbox Business account with **admin access**

---

## Project Structure

src/main/java/com/example/dropbox/
├── auth/        # Optional class to generate access token manually
├── controller/  # REST controllers
├── service/     # Services to call Dropbox API
├── model/       # Optional DTOs or response models

src/main/resources/
├── application.properties


## Configuration

Edit `src/main/resources/application.properties`:

```properties
# Dropbox client credentials
dropbox.client.id=<YOUR_APP_KEY>
dropbox.client.secret=<YOUR_APP_SECRET>

# Dropbox admin access token
dropbox.admin.token=<YOUR_ADMIN_ACCESS_TOKEN>

## How to Run

1. Open terminal in project root.

2. Build the project:

```bash
mvn clean install

3.Run the Spring Boot application:

mvn spring-boot:run

The app will start at http://localhost:8080

Endpoints
Fetch Team Members

GET /team/members

Response: JSON with all team members.

Example using curl:

curl http://localhost:8080/team/members


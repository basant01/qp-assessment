# qp-assessment

This repository contains the code for the qp-assessment project.

## Prerequisites

Before you start, make sure you have the following installed on your machine:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Maven](https://maven.apache.org/download.cgi)

## Building the Application

### 1. Build JAR File

Navigate to the root of the project and run the following command to build the JAR file:

```bash
mvn clean package
```

## Build Docker Image
docker build . -t assessment:v1

## Running the Application

### 1. Start Mysql Database
docker-compose up -d mysql-db

### 2. Run the Application Container
docker-compose up -d assessment_app

### 3. Wait for Database Initialization
docker-compose logs -f mysql-db

## 4. Access the Application
Once the containers are up and running, you can access the application at http://localhost:8081.

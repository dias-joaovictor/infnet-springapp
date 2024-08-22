# Payment App

Payment App is a Spring Boot application running on Java 21, designed to manage payments. It runs on port 8080 and
depends on a MySQL database, which is managed using Docker Compose. The application includes a Swagger UI for API
documentation, accessible at the root URL.

## Prerequisites

- Docker and Docker Compose installed
- Java Development Kit (JDK) 21
- Gradle installed (or use the Gradle wrapper provided in the project)

## Getting Started

Follow the steps below to set up and run the project.

### 1. Running MySQL with Docker Compose

The first step is to run the MySQL database using Docker Compose. The Docker Compose file is provided in the project
root.

1. Run Docker Compose to start the MySQL container:
    ```bash
    docker compose up -d
    ```

   This command will download the MySQL image (if not already available), create a container, and start the MySQL
   service. The database will be accessible on the default MySQL port (3306).

2. Verify that the MySQL container is running:
    ```bash
    docker compose ps
    ```

### 2. Building the Project with Gradle

After setting up the MySQL database, you can build the Payment App using Gradle.

1. Clean the project and download all required dependencies:
    ```bash
    ./gradlew clean
    ```

2. Build the project:
    ```bash
    ./gradlew build
    ```

   This command will compile the code, run tests, and package the application into a JAR file.

### 3. Running the Project with Gradle

Once the project is built, you can run the Payment App.

1. Start the application:
    ```bash
    ./gradlew bootRun
    ```

   This will start the Payment App on port 8080. The application will automatically connect to the MySQL database
   running in the Docker container.

### 4. Accessing the Application

After running the application, you can access it by navigating to:

- **API Endpoint and Swagger UI**: `http://localhost:8080/`

  The root URL will bring up the Swagger UI, which provides interactive documentation for all available API endpoints.

## Stopping the Environment

To stop the application and the MySQL container:

1. Stop the Spring Boot application by pressing `Ctrl + C` in the terminal where it is running.
2. Stop and remove the Docker containers:
    ```bash
    docker compose down -v
    ```


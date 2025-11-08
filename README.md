# spring-boot-thymeleaf-products

A Spring Boot application with Thymeleaf for product management, featuring Spring Security authentication and MySQL
database integration with Docker Compose support.

## Features

- Product CRUD operations with REST API
- Thymeleaf-based web interface
- Spring Security authentication and authorization
- MySQL 9.5.0 database
- Docker Compose integration for automatic database setup
- JPA/Hibernate ORM
- Responsive UI with Bootstrap

## Prerequisites

- Java 21 or higher
- Docker and Docker Compose
- Maven (or use the included Maven wrapper)

## Quick Start with Docker Compose

This project uses Spring Boot Docker Compose support to automatically start MySQL when you run the application.

### 1. Start the Application

The easiest way to run the application is to simply start it with Maven. Docker Compose will automatically start MySQL:

```bash
./mvnw spring-boot:run
```

Spring Boot will automatically:

- Detect the `docker-compose.yml` file
- Start MySQL 9.5.0 container if not already running
- Configure the database connection
- Create the necessary database tables

### 2. Access the Application

Once started, the application will be available at:

- Web Interface: http://localhost:1111/products/page
- REST API: http://localhost:1111/products

### 3. Database Configuration

The application uses the following MySQL configuration for Docker:

- **Database**: posdb
- **Host**: localhost:3306
- **Username**: yu71
- **Password**: 53cret
- **Version**: MySQL 9.5.0

These credentials are configured in `docker-compose.yml` and `application-docker.yml`.

## Manual Docker Compose Operations

If you need to manage Docker Compose manually:

### Start MySQL Container

```bash
docker compose up -d
```

### Stop MySQL Container

```bash
docker compose down
```

### View Container Logs

```bash
docker compose logs -f mysql
```

### Remove Volumes (Clean Database)

```bash
docker compose down -v
```

## Application Profiles

The application supports multiple profiles:

- **docker** (default): Uses Docker Compose with MySQL
- **localhost**: For local development without Docker
- **heroku**: For Heroku deployment

To change profiles, edit `src/main/resources/application.yml`:

```yaml
spring:
  profiles:
    active: docker  # Change this to switch profiles
```

## Building the Application

### Compile

```bash
./mvnw clean compile
```

### Package

```bash
./mvnw clean package
```

The packaged JAR will be available in the `target/` directory.

## Project Structure

```
.
├── docker-compose.yml              # Docker Compose configuration
├── init.sql                        # Database initialization script
├── pom.xml                         # Maven configuration
└── src/
    └── main/
        ├── java/
        │   └── id/my/hendisantika/springbootthymeleafproducts/
        │       ├── config/         # Security and app configuration
        │       ├── controller/     # REST controllers
        │       ├── dto/            # Data transfer objects
        │       ├── entity/         # JPA entities
        │       ├── repository/     # JPA repositories
        │       └── service/        # Business logic
        └── resources/
            ├── application.yml                 # Main configuration
            ├── application-docker.yml          # Docker profile config
            ├── application-localhost.yml       # Localhost profile config
            ├── application-heroku.yml          # Heroku profile config
            ├── static/                         # Static resources
            └── templates/                      # Thymeleaf templates
```

## Technologies Used

- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **Spring Security**
- **Thymeleaf**
- **MySQL 9.5.0**
- **Docker & Docker Compose**
- **Lombok**
- **Bootstrap 3**
- **Java 21**

## Development

### Hot Reload

The application includes Spring Boot DevTools for automatic restart during development.

### Database Schema

The application uses Hibernate's `ddl-auto: update` setting in the Docker profile, which automatically creates and
updates database tables based on JPA entities.

## Troubleshooting

### Docker Compose Not Starting

Ensure Docker is running:

```bash
docker --version
docker compose version
```

### Port Already in Use

If port 3306 or 1111 is already in use, you can:

1. Stop the conflicting service
2. Change the port mapping in `docker-compose.yml` or `application-docker.yml`

### Database Connection Issues

Check if MySQL container is running:

```bash
docker compose ps
```

View MySQL logs:

```bash
docker compose logs mysql
```

## License

This project is open source and available under the MIT License.

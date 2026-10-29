# spring-boot-thymeleaf-products

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-thymeleaf-products/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-thymeleaf-products/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-6DB33F?logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-9.5.0-4479A1?logo=mysql&logoColor=white)

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

- Java 25 (JDK 25, e.g. Eclipse Temurin)
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

### Run Tests

The context-load test connects to a real MySQL database (the `docker` profile settings), so start MySQL first:

```bash
docker compose up -d
./mvnw test
```

## Continuous Integration

GitHub Actions (`.github/workflows/maven.yml`) runs on every push and pull request to `main`, and can also be started
manually:

- Sets up **Temurin JDK 25** with Maven dependency caching
- Starts a **MySQL 9.5.0** service container (same credentials as `docker-compose.yml`)
- Builds and tests with `./mvnw -B package`
- On pushes to `main`, submits the Maven dependency graph to GitHub to improve Dependabot alerts

## Dependency Updates (Dependabot)

`.github/dependabot.yml` keeps dependencies current:

| Ecosystem      | Schedule                 | Notes                                                                  |
|----------------|--------------------------|------------------------------------------------------------------------|
| Maven          | Daily, 21:00 WIB         | Spring/Thymeleaf and other minor/patch bumps are grouped into single PRs |
| GitHub Actions | Weekly (Monday), 21:00 WIB | All action updates grouped into one PR                                 |
| Docker Compose | Weekly (Monday), 21:00 WIB | Tracks the MySQL image in `docker-compose.yml`                         |

PRs are labelled `dependencies` and use conventional commit prefixes (`build(deps)`, `ci(deps)`, `build(docker)`).

## Project Structure

```
.
├── .github/
│   ├── dependabot.yml              # Dependabot configuration
│   └── workflows/maven.yml         # GitHub Actions CI pipeline
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

- **Spring Boot 4.1.2**
- **Spring Data JPA**
- **Spring Security 7**
- **Thymeleaf**
- **MySQL 9.5.0**
- **Docker & Docker Compose**
- **Lombok**
- **Bootstrap 3**
- **Java 25**

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

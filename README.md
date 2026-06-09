# policy-overview-bff

An application for Chubb's APAC operations. The BFF sits between the front-end
application and downstream systems, aggregating and transforming policy data into
a frontend-friendly format (see [.claude/context/requirements.md](.claude/context/requirements.md)).

## Tech stack

| Technology  | Version    |
| ----------- | ---------- |
| Java (JDK)  | 21 (LTS)   |
| Spring Boot | 3.4.5      |
| Build tool  | Maven 3.9.x (wrapper committed) |
| Database    | PostgreSQL 16.x |
| Migrations  | Flyway 10.x |
| Testing     | JUnit 5 (Jupiter) |

## Prerequisites

- A JDK 21 or newer on `PATH` (the build targets Java 21).
- A running PostgreSQL instance for `bootRun` and integration tests
  (integration tests use Testcontainers, which requires Docker).

## Build & run

```bash
# Compile
./mvnw compile

# Run the test suite
./mvnw test

# Build the executable jar
./mvnw clean package

# Start the application
./mvnw spring-boot:run
```

On Windows use `mvnw.cmd` in place of `./mvnw`.

Database connection is configured via environment variables (defaults in
[application.yml](src/main/resources/application.yml)): `DB_URL`, `DB_USERNAME`,
`DB_PASSWORD`, and `SERVER_PORT`.

## Project layout

Source follows the layered architecture defined in
[.claude/rules/architecture.md](.claude/rules/architecture.md), under the base
package `com.chubb.policyoverview`:

```
api/            REST controllers, DTOs, mappers, exception handling
domain/         Pure business models (no framework deps)
service/        Business logic / use cases
infrastructure/ Persistence (JPA entities, repositories, mappers), cache
config/         Spring configuration
common/         Cross-cutting concerns (exceptions, utils, logging)
```

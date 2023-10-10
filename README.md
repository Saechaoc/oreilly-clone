# O'Reilly Clone
An e-commerce platform inspired by O'Reilly, implemented using Spring Boot and Spring Data JPA for the backend.

# Overview
This project is structured into several layers, ensuring a clean architecture and separation of concerns:
1. Backend Layer: Implements business logic, API endpoints, and data management with Spring Boot.
2. Configuration Layer: Handles application configuration, security settings, and JWT token management.
3. Build & Dependency Management: Utilizes Gradle for dependency management and project building.

# System Architecture
## N-Tier Architecture
* Controller Layer: Manages API endpoints and HTTP request handling.
* Service Layer: Contains business logic and interacts with models and repositories for data access.
* Model Layer: Defines data structures and ORM entities.
* Repository Layer: Manages data access, potentially interacting with a database.
* Configuration Layer: Manages application configuration, such as security settings and JWT token management.

```mermaid
graph TB

    frontend[Frontend Layer]
    controller[Controller Layer]
    service[Service Layer]
    repository[Repository Layer]
    model[Model Layer]
    database[Database]
    config[Configuration Layer]

    frontend -->|HTTP Requests & Responses| controller
    controller -->|Method Calls| service
    service -->|Data & Logic Processing| model
    service -->|CRUD Operations| repository
    repository -->|Data Access| model
    repository -->|CRUD Operations| database
    controller -->|Utilize Configurations| config
    service -->|Utilize Configurations| config

    style frontend fill:#ffcc66,stroke:#333,stroke-width:2px
    style controller fill:#ff9999,stroke:#333,stroke-width:2px
    style service fill:#99ff99,stroke:#333,stroke-width:2px
    style repository fill:#ccccff,stroke:#333,stroke-width:2px
    style model fill:#99ccff,stroke:#333,stroke-width:2px
    style database fill:#cc99ff,stroke:#333,stroke-width:2px
    style config fill:#ccffcc,stroke:#333,stroke-width:2px

```

# Contact
Chris_Saechao@live.com
Project Link: https://o-reilly-2-0.vercel.app/

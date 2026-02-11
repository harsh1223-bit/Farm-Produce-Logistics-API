
AgroMove - Improved API scaffold

What's improved:
- Multi-stage Dockerfile (builds jar inside image)
- Method-level security (@PreAuthorize)
- DTOs + validation for produce endpoints
- Global exception handling (consistent JSON errors)
- Paging support for list endpoints
- CORS config and actuator health endpoint
- OpenAPI metadata for better Swagger UI

How to run (Docker, recommended):
1) Build and run with Docker (no local maven required):
   docker compose up --build

2) Or build locally then run:
   mvn -B -DskipTests clean package
   docker compose up --build

Default admin credentials (seeded):
  username: admin
  password: admin123

Swagger UI: http://localhost:8080/swagger-ui/index.html


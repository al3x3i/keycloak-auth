## Spring Boot Keycloak Integration

### Overview

This project demonstrates the integration of a Spring Boot application with Keycloak for authentication and
authorization. The application manages customer information, and access to certain endpoints is restricted based on
Keycloak roles.

### Running the Application

1. Ensure Keycloak is running at http://localhost:9999.
```shell
cd local
docker-compose up
```
2. Run the Spring Boot application at http://localhost:8081.
3. Access the application and log in using Keycloak credentials. 
```text
Login: user-temp
Password: auth-psw
```

# roman-letter-converter-backend
The application provides endpoints to convert decimal and binary to Roman numerals

## Requirements

For building and running the application you need:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)


## Running the application

# Locally
We need to start the database docker container in order to establish a successful connection to persist Audit logs into table.
Execute the command below in /docker folder
```shell
$ docker-compose up -d
```
You could start the application with two different ways
* execute the `main` method in the `com.example.converter.ConverterApplication` class from your IDE.
* use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)
back to application root folder and execute the command below.
```shell
$ mvn spring-boot:run
```


## Technologies used
Application is Spring Boot application and other Spring features and libraries has been used
* Spring REST
* Spring Data JPA (with Hibernate as ORM provider)

* PostgreSQL

* Flyway - to control the DB migrations
* Lombok - to automatically generate getter/setter/builder and constructors
* Mockito - for service layer mock tests

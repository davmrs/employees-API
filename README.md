# Employees - REST API

Simple REST API to manage employees created with Spring Boot, Java 8 and Maven.

## Table of Contents

- [Getting Started](#getting-started)
- [Build and Run](#build-and-run)
- [Request and Response Examples](#request-and-response-examples)
- [Technologies](#technologies)
- [Authors](#authors)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing
purposes.

### Prerequisites

Download the project zip or clone the repository with the following command:

```
git clone https://github.com/davmrs/employees-API
```

## Build and Run

Build jar file with Maven:

```
mvn package
```

Run the jar file using:

```
java -jar target/employees-API-1.0.0.jar
```

Alternatively, you can go to the root directory of the application and run the app without packaging it using:

```
mvn spring-boot:run
```

The app will start running at http://localhost:8080.

## Request and Response Examples

### API Resources

- [GET /employees](#get-employees)
- [GET /employees/[id]](#get-employeesid)
- [POST /employees](#post-employees)
- [PUT /employees/[id]](#put-employeesid)
- [DELETE /employees/[id]](#delete-employeesid)

### GET /employees

Retrieve all **active** employees.

Example: http://localhost:8080/api/v1/employees

Response body:

      [
          {
              "id": 1,
              "firstName": "David",
              "middleInitial": "S",
              "lastName": "Mora",
              "dateBirth": "1989-02-08",
              "dateEmployment": "2015-09-20",
              "active": true
          },
          {
              "id": 2,
              "firstName": "Juan",
              "middleInitial": "A",
              "lastName": "Guevara",
              "dateBirth": "1978-09-03",
              "dateEmployment": "2017-03-15",
              "active": true
          },
          {
              "id": 4,
              "firstName": "Fernando",
              "middleInitial": "J",
              "lastName": "Trinidad",
              "dateBirth": "1990-12-28",
              "dateEmployment": "2018-04-05",
              "active": true
          }
      ]

### GET /employees/[id]

Retrieve the employee with the Id specified on URL only if it is **active**.

Example: http://localhost:8080/api/v1/employees/2

Response body:

      {
          "id": 2,
          "firstName": "Juan",
          "middleInitial": "A",
          "lastName": "Guevara",
          "dateBirth": "1978-09-03",
          "dateEmployment": "2017-03-15",
          "active": true
      }

### POST /employees

Create a new employee.

Example: Create – POST http://localhost:8080/api/v1/employees

Request body:

      {
          "firstName": "Rodrigo",
          "middleInitial": "P",
          "lastName": "Garces",
          "dateBirth": "1998-01-01",
          "dateEmployment": "2019-11-09"
      }

### PUT /employees/[id]

Update existing employee with the Id specified on URL.

Example: Update – PUT http://localhost:8080/api/v1/employees/4

Request body:

      {
          "firstName": "Fernanda",
          "middleInitial": "M",
          "lastName": "Sanchez"
      }

### DELETE /employees/[id]

Switch status of employee with the Id specified on URL to **inactive**.

Example: http://localhost:8080/api/v1/employees/4

Header:

```
Authorization       Basic RGF2aWQgTW9yYTpwYXNzd29yZDEyMw==
```

## Technologies

Project built with:

* [Spring Boot](https://spring.io/) - Java Framework used for building production-ready applications
* [Java SDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java SE
  Development Kit 8
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **David Mora** - *Initial work* - [davmrs](https://github.com/davmrs)

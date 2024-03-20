# Book Message Service
The service is written in Java using Springboot and PostgreSQL for database storage.
This application acts as a message service for books, using Apache Kafka for message passing.

## Components

### BookController

Defines a REST API endpoint `/api/book/sendToKafka` that receives a `BookRequest` object in the request body and sends it to a Kafka topic called `kafkaTopic`.

### BookRequest

A DTO representing the information of a book (name, author, description, price).

### BookEntity

Represents the entity of a book in the database, with fields for id, name, author, description, and price.

### BookRepository

Extends JpaRepository to provide CRUD operations for `BookEntity`.

### BookServiceImpl

Listens to the `kafkaTopic` for incoming `BookRequest` messages. When a message is received, it converts it to a `BookEntity` and saves it to the database using the `BookRepository`.

### Kafka Configuration

Includes configurations for the Kafka producer and consumer, specifying the Kafka server address (`localhost:9092`), default topic (`kafkaTopic`), and serialization/deserialization settings for the message payloads.

### Spring Boot Application Configuration

The `application.yml` file contains configuration properties for the Spring Boot application, including the database connection settings and Kafka configuration properties.

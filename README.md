Simple E-Commerce REST API (Spring Boot)
Overview

This project is a simple Java backend application built using Spring Boot.
It implements a RESTful API for managing a collection of items (similar to products in an e-commerce system).

The application uses an in-memory data store (ArrayList) to manage items and provides API endpoints to:

Add a new item

Get a single item by ID

No external database is used.

Technologies Used

Java 21

Spring Boot

Maven

In-memory storage (ArrayList)

How to Run the Application
1. Clone the project
   git clone <your-repo-link>
   cd <project-folder>

2. Build the project
   mvn clean package

3. Run the application
   java -jar target/Ecom-app.jar


OR

mvn spring-boot:run


The application runs on:

http://localhost:8080

Base URL
http://localhost:8080/app

API Endpoints
1. Add a New Item

Endpoint -->POST /app/addItem


Request Body Example

{
"id": 1,
"name": "Wireless Mouse",
"description": "Ergonomic wireless mouse",
"rating": 4,
"quantity": 50,
"inStock": true,
"brand": "LogiTech",
"category": "Electronics"
}


Validation Rules

Name must not be null or empty

Rating must be between 1 and 5

Quantity must be greater than or equal to 0

Brand must not be null

Category must not be null

If validation fails, the API returns:

400 Bad Request

2. Get Item by ID

Endpoint

GET /app/get/{id}


Example

GET /app/get/1


Response Example

{
"id": 1,
"name": "Wireless Mouse",
"description": "Ergonomic wireless mouse",
"rating": 4,
"quantity": 50,
"inStock": true,
"brand": "LogiTech",
"category": "Electronics"
}


If item is not found, the API returns:

404 Not Found

Implementation Details
Item Model

Represents an item with the following fields:

id (int)

name (String)

description (String)

rating (int)

quantity (int)

inStock (boolean)

brand (String)

category (String)

Validation is implemented using either manual validation or Bean Validation annotations.

Data Storage

Items are stored in:

private List<ItemModel> items = new ArrayList<>();


This acts as an in-memory database.

Note:

Data is not persisted.

Restarting the application clears all data.

Error Handling

Custom error responses are returned for:

Validation errors (400)

Item not found (404)

Project Structure
com.shivam.Ecom
│
├── controller
├── service
├── model
├── exception
└── EcomApplication.java

Important Notes

This project uses an in-memory data store.

No external database is required.

Designed for learning REST API fundamentals.

Can be containerized using Docker for deployment.
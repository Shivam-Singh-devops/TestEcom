E-Commerce REST API (Spring Boot)
Overview

This project is a simple Java backend application built using Spring Boot.
It implements a RESTful API for managing a collection of items, similar to products in an e-commerce system.

For all the API check last(in simple)

The application allows users to:

Add a new item

Retrieve all items

Retrieve a single item by ID

Update an existing item

Delete an item

The data is stored in-memory using an ArrayList, meaning no external database is required.

Technologies Used

Java 21

Spring Boot

Maven

REST API

In-memory data storage (ArrayList)

Project Structure
com.shivam.Ecom
│
├── controller
│   └── Ecom.java
│
├── service
│   └── itemService.java
│
├── repo
│   └── EcomRepo.java
│
├── model
│   └── itemModel.java
│
└── EcomApplication.java

How to Run the Application
1. Clone the Repository
git clone <your-repository-link>
cd <project-folder>

2. Build the Project
mvn clean package

3. Run the Application
java -jar target/Ecom-app.jar


OR

mvn spring-boot:run


The application will start on:

http://localhost:8080

Base URL
http://localhost:8080/app


When deployed:

https://your-deployed-url/app

API Endpoints
1. Get All Items
Endpoint
GET /app/getAll

Description

Returns a list of all items stored in memory.

Response

Status: 200 OK

[
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
]

2. Get Item by ID
Endpoint
GET /app/get/{id}

Description

Returns a single item based on its ID.

Example
GET /app/get/1

Success Response

Status: 200 OK

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

Error Response

Status: 404 Not Found
Returned if the item does not exist.

3. Add New Item
Endpoint
POST /app/addItem

Description

Adds a new item to the in-memory data store.

Request Body Example
{
  "id": 2,
  "name": "Mechanical Keyboard",
  "description": "RGB backlit keyboard",
  "rating": 5,
  "quantity": 60,
  "inStock": true,
  "brand": "KeyChron",
  "category": "Electronics"
}

Validation Rules

name must not be null or empty

rating must be between 1 and 5

quantity must be greater than or equal to 0

brand must not be null

category must not be null

Success Response

Status: 200 OK

Returns the created item.

Error Response

Status: 400 Bad Request

Example:

{
  "status": 400,
  "error": "Bad Request",
  "message": "Name is required",
  "timestamp": "2026-02-11T11:23:04"
}

4. Update Item
Endpoint
PUT /app/update/{id}

Description

Updates an existing item using its ID.

Example
PUT /app/update/1

Request Body
{
  "name": "Updated Mouse",
  "description": "Updated description",
  "rating": 4,
  "quantity": 40,
  "inStock": true,
  "brand": "LogiTech",
  "category": "Electronics"
}

Success Response

Status: 200 OK

Returns the updated item.

Error Response

404 Not Found – Item does not exist

400 Bad Request – Validation fails

5. Delete Item
Endpoint
DELETE /app/delete/{id}

Description

Deletes an item by its ID.

Example
DELETE /app/delete/1

Success Response

Status: 200 OK

No response body.

Error Response

Status: 404 Not Found

Data Storage

Items are stored in an in-memory ArrayList.

No external database is used.

All data will be lost when the application restarts.

Input Validation

Validation is implemented to ensure:

Required fields are present

Rating values are within valid range

Quantity is non-negative

Invalid input returns 400 Bad Request


It uses RESTful conventions for HTTP methods.

It does not persist data beyond runtime.


API
http://localhost:8080/app/getAll ---> to get all the items.
http://localhost:8080/app/get/{id}  ---> to get the single item from the items.
http://localhost:8080/app/delete/{id}  ----> to delete the item from the database
http://localhost:8080/app/addItem    ---> to add the element in the in-database (you have to provide the itemModel)
follow this order->
Example:
{
  "id": 2,
  "name": "Mechanical Keyboard",
  "description": "RGB backlit keyboard",
  "rating": 5,
  "quantity": 60,
  "inStock": true,
  "brand": "KeyChron",
  "category": "Electronics"
}
http://localhost:8080/app/update/{id}   ---> to update any item by the id in the in-database.

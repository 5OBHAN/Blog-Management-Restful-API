# Blog Management Restful API

This is a RESTful API for managing blogs, built using Java.

## Features

- Create, Read, Update, and Delete blog posts.
- Search blogs by ID.
- Shows blogs with Pagination.

## Getting Started

### Prerequisites

- Java 21 _(Recomended)_ or later
- Maven 3.9.9 or later
- A database i.e., MySQL _(Recomended)_

### Installation

1. Clone the repository:
    
    ```sh
    git clone https://github.com/5OBHAN/Blog-Management-Restful-API.git && cd Blog-Management-Restful-API
    ```

2. Configure the database connection in _`application.properties`_:
    
    > **Path:** src/main/resources/application.properties
    
    ```properties
    spring.datasource.url=jdbc:mysql://<HOST>:<PORT>/{YOUR_DB_NAME}
    spring.datasource.username={YOUR_DB_USERNAME}
    spring.datasource.password={YOUR_DB_PASSWORD}
    ```

3. Build and run the application:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## API Endpoints

### Blog Posts
- `POST /api/v1/blogs` - _Create a new blog post_
- `GET /api/v1/blogs/{id}` - _Get a single blog post by ID_
- `GET /api/v1/blogs` - _Get all blog posts_
- `PUT /api/v1/blogs/{id}` - _Update a blog post by ID_
- `DELETE /api/v1/blogs/{id}` - _Delete a blog post by ID_

## License
This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

# MVP Hotel Booking API

This is a simple Hotel Booking API built using Java 17 and Spring Boot 3.x.x. It provides endpoints for creating, viewing, updating, and canceling hotel reservations.

## Prerequisites

- Java 17
- Maven
- Spring Boot 3.2.2

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/gauransh5/mvpbooking
    ```

2. Navigate to the project directory:

    ```bash
    cd mvpbooking
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    java -jar target/MVPBooking-0.0.1-SNAPSHOT.jar
    ```

5. Access the API at `http://localhost:8080/api/v1`.

## API Endpoints

### Create Booking

- **Endpoint:** `POST /api/v1`
  - **Request Payload:**
      ```json
      {
      "userId": 108,
      "hotelId": 208,
      "checkInDate": "2024-11-29",
      "checkOutDate": "2024-11-25"
      }
      ```
- **Response:**
    ```json
    {
      "message": "Booking created successfully. Booking ID: 1"
    }
    ```

### View All Bookings

- **Endpoint:** `GET /api/v1/bookings`
- **Response:**
    ```json
    [

    {
        "id": 1,
        "userId": 101,
        "hotelId": 201,
        "checkInDate": "2024-05-20",
        "checkOutDate": "2024-05-25"
    },
    {
        "id": 2,
        "userId": 102,
        "hotelId": 202,
        "checkInDate": "2024-06-10",
        "checkOutDate": "2024-06-15"
    },
      // More bookings...
    ]
    ```

### View a Specific Booking

- **Endpoint:** `GET /api/v1/bookings/{bookingId}`
- **Response:**
    ```json
    {
    "id": 1,
    "userId": 101,
    "hotelId": 201,
    "checkInDate": "2024-05-20",
    "checkOutDate": "2024-05-25"
    }
    ```

### Update Booking

- **Endpoint:** `PUT /api/v1/bookings/{bookingId}`
- **Request Payload:**
    ```json
    {
    "id": 1,
    "userId": 101,
    "hotelId": 201,
    "checkInDate": "2024-05-20",
    "checkOutDate": "2024-05-25"
    }
    ```
- **Response:**
    ```json
    {
      "message": "Booking updated successfully"
    }
    ```

### Delete Booking

- **Endpoint:** `DELETE /api/v1/bookings/{bookingId}`
- **Response:**
    ```json
    {
      "message": "Booking deleted successfully"
    }
    ```

## Configuration

- The application uses an H2 in-memory database by default. You can modify the `application.properties` file to configure other databases.


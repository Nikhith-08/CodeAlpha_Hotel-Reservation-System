# CodeAlpha_Hotel-Reservation-System
# Hotel Reservation System

The **Hotel Reservation System** is a Java-based application designed to simulate a simple hotel booking process. It allows users to search for available rooms by category, make reservations, view booking details, and provides placeholders for advanced features such as payment processing. This project demonstrates the use of object-oriented design principles and lays the foundation for further expansion into a full-fledged reservation system.

---

## Table of Contents

1. [Features](#features)
2. [Project Structure](#project-structure)
   - [Core Classes](#core-classes)
3. [Key Functionalities](#key-functionalities)
4. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#installation)
   - [Running the Program](#running-the-program)
5. [Sample Room Data](#sample-room-data)



---

## Features

- **Room Search and Categorization**: Users can search for available rooms by type (e.g., Single, Double, Suite).
- **Reservation Management**: Guests can book rooms by specifying their details, and reservations are tracked in the system.
- **Booking Details**: View all reservations, including room details and total charges.
- **Menu-Driven Interface**: Easy-to-use console-based menu for user interaction.
- **Scalability**: Modular design for easy integration with advanced features like payment processing or API services.

---

## Project Structure

### Core Classes

1. **Room**
   - Attributes: `roomNumber`, `category`, `price`, `isAvailable`
   - Methods: `getRoomNumber()`, `getCategory()`, `getPrice()`, `isAvailable()`, `setAvailable()`, `toString()`

2. **Reservation**
   - Attributes: `reservationId`, `room`, `guestName`, `numberOfNights`, `totalAmount`
   - Methods: `getReservationId()`, `getRoom()`, `getTotalAmount()`, `toString()`

3. **Hotel**
   - Manages the list of rooms and reservations.
   - Methods: `addRoom()`, `searchAvailableRooms()`, `makeReservation()`, `displayReservations()`

4. **HotelReservationSystem**
   - Main entry point.
   - Provides a user-friendly menu-driven interface for the system.

---

## Key Functionalities

1. **Room Search**: Users can search for rooms by category and view availability.
2. **Reservation Creation**: Guests can reserve available rooms, with automatic price calculation based on the number of nights.
3. **View Reservations**: All existing reservations are displayed, including guest details and booking information.
4. **Placeholder for Payment Processing**: Designed for integration with payment gateways or APIs for processing payments in the future.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) version 8 or higher.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with Java support.

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Nikhith-08/CodeAlpha_Hotel-Reservation-System.git
2. Navigate to the Directory:
   ```bash
    cd CodeAlpha_Hotel-Reservation-System
3. Compile the Java Code:
   ```bash
    javac Hotel_Reservation_System.java
   
### Running the Program
To run the program
   ```bash
   java Hotel_Reservation_System
   ```
### Sample Room Data
The following rooms are preloaded into the system:

| Room Number | Category        | Price per Night |
|-------------|-----------------|-----------------|
| 101         | Single          | $50.00          |
| 102         | Single          | $55.00          |
| 201         | Double          | $80.00          |
| 202         | Double          | $85.00          |
| 301         | Suite           | $120.00         |
| 302         | Suite           | $130.00         |
| 401         | Deluxe Suite    | $200.00         |
| 501         | Penthouse       | $500.00         |

These rooms provide a range of options for guests with different budgets and preferences.

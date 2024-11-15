
import java.util.ArrayList;
import java.util.Scanner;

class Room {

    private final int roomNumber;
    private final String category;
    private final double price;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true; // default available status
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("Room %d (%s) - $%.2f per night - %s",
                roomNumber, category, price, isAvailable ? "Available" : "Booked");
    }
}

class Reservation {

    private final int reservationId;
    private final Room room;
    private final String guestName;
    private final double totalAmount;

    public Reservation(int reservationId, Room room, String guestName, int numberOfNights) {
        this.reservationId = reservationId;
        this.room = room;
        this.guestName = guestName;
        this.totalAmount = room.getPrice() * numberOfNights;
        room.setAvailable(false); // mark room as booked
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return String.format("Reservation ID: %d, Guest: %s, Room: %d, Total Amount: $%.2f",
                reservationId, guestName, room.getRoomNumber(), totalAmount);
    }
}

class Hotel {

    final ArrayList<Room> rooms;
    private final ArrayList<Reservation> reservations;
    private int reservationCounter = 1;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // Method to add a room to the hotel
    public void addRoom(int roomNumber, String category, double price) {
        rooms.add(new Room(roomNumber, category, price));
    }

    // Method to search for available rooms by category
    public ArrayList<Room> searchAvailableRooms(String category) {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // Method to make a reservation
    public Reservation makeReservation(Room room, String guestName, int numberOfNights) {
        Reservation reservation = new Reservation(reservationCounter++, room, guestName, numberOfNights);
        reservations.add(reservation);
        System.out.println("\nReservation successful! " + reservation);
        return reservation;
    }

    // Method to display all reservations
    public void displayReservations() {
        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations found.");
            return;
        }
        System.out.println("\nCurrent Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}

public class Hotel_Reservation_System {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Hotel hotel = new Hotel();
            
            // Sample room data
            // Sample room data with various categories and prices
            hotel.addRoom(101, "Single", 50.00);
            hotel.addRoom(102, "Single", 55.00);
            hotel.addRoom(103, "Single", 60.00);
            hotel.addRoom(201, "Double", 80.00);
            hotel.addRoom(202, "Double", 85.00);
            hotel.addRoom(203, "Double", 90.00);
            hotel.addRoom(301, "Suite", 120.00);
            hotel.addRoom(302, "Suite", 130.00);
            hotel.addRoom(303, "Suite", 140.00);
            hotel.addRoom(401, "Deluxe Suite", 200.00);
            hotel.addRoom(402, "Deluxe Suite", 220.00);
            hotel.addRoom(403, "Deluxe Suite", 250.00);
            hotel.addRoom(501, "Penthouse", 500.00);
            hotel.addRoom(502, "Penthouse", 550.00);

            
            boolean exit = false;
            System.out.println("\nWelcome to the Hotel Reservation System!");

            while (!exit) {
                System.out.println("\nHotel Reservation System Menu:");
                System.out.println("1. Search for Available Rooms");
                System.out.println("2. Make a Reservation");
                System.out.println("3. View Reservations");
                System.out.println("4. Exit");
                System.out.print("\nChoose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("\nEnter room category (Single, Double, Suite, Deluxe Suite, Penthouse): ");
                        String category = scanner.nextLine();
                        ArrayList<Room> availableRooms = hotel.searchAvailableRooms(category);
                        if (availableRooms.isEmpty()) {
                            System.out.println("\nNo available rooms in the selected category.");
                        } else {
                            System.out.println("\nAvailable Rooms:");
                            for (Room room : availableRooms) {
                                System.out.println(room);
                            }
                        }
                    }
                    case 2 -> {
                        System.out.print("\nEnter room number to reserve: ");
                        int roomNumber = scanner.nextInt();
                        System.out.print("Enter guest name: ");
                        scanner.nextLine(); // Consume newline
                        String guestName = scanner.nextLine();
                        System.out.print("Enter number of nights: ");
                        int nights = scanner.nextInt();
                        
                        Room selectedRoom = null;
                        for (Room room : hotel.rooms) {
                            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                                selectedRoom = room;
                                break;
                            }
                        }
                        
                        if (selectedRoom != null) {
                            hotel.makeReservation(selectedRoom, guestName, nights);
                        } else {
                            System.out.println("\nRoom is either unavailable or does not exist.");
                        }
                    }
                    case 3 -> hotel.displayReservations();
                    case 4 -> {
                        exit = true;
                        System.out.println("\nExiting the Hotel Reservation System. Have a great stay!\n");
                    }
                    default -> System.out.println("\nInvalid option. Please try again.");
                }
            }
        }
    }
}

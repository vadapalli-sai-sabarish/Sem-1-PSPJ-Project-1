import java.util.Scanner;

public class CinemaBooking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] seats = new int[30];

        int choice, movieChoice, seatNumber;
        int bookedSeats = 0;
        int price = 0;
        String movieName = "";

        int i = 0;

        while (i < 30) {
            seats[i] = 0;
            i++;
        }

        System.out.println("===== WELCOME TO CINEMA =====");
        System.out.println("1. Avatar - Rs.200");
        System.out.println("2. Avengers - Rs.180");
        System.out.println("3. Jawan - Rs.150");

        System.out.print("Select your movie: ");
        movieChoice = sc.nextInt();

        switch (movieChoice) {

            case 1:
                movieName = "Avatar";
                price = 200;
                break;

            case 2:
                movieName = "Avengers";
                price = 180;
                break;

            case 3:
                movieName = "Jawan";
                price = 150;
                break;

            default:
                System.out.println("Invalid movie selection!");
                sc.close();
                return;
        }

        System.out.println("\nSelected Movie: " + movieName);
        System.out.println("Ticket Price: Rs." + price);

        do {
            System.out.println("\n===== CINEMA BOOKING MENU =====");
            System.out.println("1. Display Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n========== CINEMA SCREEN ==========");

                    for (int j = 0; j < 30; j++) {

                        if (seats[j] == 0) {
                            System.out.print("[O] ");
                        } else {
                            System.out.print("[X] ");
                        }

                        if ((j + 1) % 6 == 0) {
                            System.out.println();
                        }
                    }

                    System.out.println("\nO = Available");
                    System.out.println("X = Booked");
                    break;

                case 2:
                    System.out.print("Enter seat number (1-30): ");
                    seatNumber = sc.nextInt();

                    if (seatNumber >= 1 && seatNumber <= 30) {

                        if (seats[seatNumber - 1] == 0) {

                            seats[seatNumber - 1] = 1;
                            bookedSeats++;

                            System.out.println("Seat booked successfully!");

                        } else {
                            System.out.println("Seat already booked!");
                        }

                    } else {
                        System.out.println("Invalid seat number!");
                    }
                    break;

                case 3:
                    System.out.print("Enter seat number to cancel: ");
                    seatNumber = sc.nextInt();

                    if (seatNumber >= 1 && seatNumber <= 30) {

                        if (seats[seatNumber - 1] == 1) {

                            seats[seatNumber - 1] = 0;
                            bookedSeats--;

                            System.out.println("Booking cancelled!");

                        } else {
                            System.out.println("Seat is not booked!");
                        }

                    } else {
                        System.out.println("Invalid seat number!");
                    }
                    break;

                case 4:
                    System.out.println("\n========== CINEMA BILL ==========");
                    System.out.println("Movie Name    : " + movieName);
                    System.out.println("Ticket Price  : Rs." + price);
                    System.out.println("Booked Seats  : " + bookedSeats);
                    System.out.println("Seat Numbers  : ");

                    for (int j = 0; j < 30; j++) {
                        if (seats[j] == 1) {
                            System.out.print((j + 1) + " ");
                        }
                    }

                    int total = bookedSeats * price;

                    System.out.println("\n-------------------------------");
                    System.out.println("Total Amount  : Rs." + total);
                    System.out.println("-------------------------------");
                    System.out.println("Thank you for booking!");
                    break;

                case 5:
                    System.out.println("Thank you! Visit Again.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
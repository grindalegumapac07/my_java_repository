import java.util.Scanner;

public class MyMidtermLabExam {
    // Universal scanner and array for storing tickets:
    static Scanner input = new Scanner(System.in);
    static String[][] ticketList = new String[5][3]; // Maximum of 5 tickets. Each ticket consists of 3 information: issue description, urgency level, status.
    static int ticketCount = 0;

    public static void main(String[] args) {
        int userOption;

        do {
            System.out.println();
            System.out.println("=== IT Ticket System ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");

            // User input
            System.out.print("Enter choice: ");
            userOption = input.nextInt();

            // Handle user choice
            switch (userOption) {
                case 1:
                    addTicket();
                    break;
            
                case 2:
                    updateTicketStatus();
                    break;

                case 3:
                    showTickets();
                    break;

                case 4:
                    generateReport();
                    break;
                
                case 5:
                    System.out.println("Exiting... Thank you!");
                    input.close();
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (userOption != 5);
    }

    static void addTicket() {
        if(ticketCount >= 5) {
            System.out.println("Maximum number of tickets reached.");
            return;
        }

        input.nextLine();

        // Input ticket info:
        System.out.print("Enter issue description: ");
        String issueDescription = input.nextLine();

        System.out.print("Enter urgency level (Low / Medium / High): ");
        String urgencyLevel = input.nextLine();

        // Save ticket info into array:
        ticketList[ticketCount][0] = issueDescription;
        ticketList[ticketCount][1] = urgencyLevel;
        ticketList[ticketCount][2] = "Pending"; // Default issue status

        ticketCount++;

        System.out.println("Ticket successfully added!");
    }

    static void updateTicketStatus() {
        System.out.println();
        System.out.println("--- All Tickets ---");

        // Display all tickets that are not yet resolved
        for(int i = 0; i < ticketCount; i++) {
            if(!ticketList[i][2].equalsIgnoreCase("Resolved")) {
                System.out.println((i + 1) + ". [" + ticketList[i][1] + "] " + ticketList[i][0] + " - Status: " + ticketList[i][2]);
            }
        }

        System.out.print("Enter ticket number to update: ");
        int ticketNumber = input.nextInt();
        input.nextLine();

        if(ticketNumber < 1 || ticketNumber > ticketCount) {
            System.out.println("Invalid ticket number!");
            return;
        }

        int index = ticketNumber - 1;

        if (ticketList[index][2].equalsIgnoreCase("Resolved")) {
            System.out.println("This ticket is already \"Resolved\" and cannot be updated.");
            return;
        }

        System.out.print("Enter new status (In Progress / Resolved): ");
        String newStatus = input.nextLine();

        // Update status if input is valid
        if(newStatus.equalsIgnoreCase("In Progress") || newStatus.equalsIgnoreCase("Resolved")) {
            ticketList[index][2] = newStatus;
            System.out.println("Ticket status updated.");
        } else {
            System.out.println("Invalid status! Status not updated.");
        }
    }

    static void showTickets() {
        System.out.println();
        System.out.println("--- All Tickets ---");
        
        for(int i = 0; i < ticketCount; i++) {
            System.out.println((i + 1) + ". [" + ticketList[i][1] + "] " + ticketList[i][0] + " - Status: " + ticketList[i][2]);
        }
    }

    static void generateReport() {
        int pendingOrInProgress = 0;
        int resolved = 0;

        for(int i = 0; i < ticketCount; i++) {
            String status = ticketList[i][2];
            if (status.equalsIgnoreCase("Resolved")) {
                resolved++;
            } else {
                pendingOrInProgress++;
            }
        }

        // Display ticket status counters:
        System.out.println();
        System.out.println("--- Ticket Report ---");
        System.out.println("Total Tickets: " + ticketCount);
        System.out.println("Pending Tickets: " + pendingOrInProgress);
        System.out.println("Resolved Tickets: " + resolved);
    }
}
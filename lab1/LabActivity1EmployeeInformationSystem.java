// Importing Scanner class from java package for user input.
import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {
    public static void main(String[] args) {
        // Creating an instance for the Scanner.
        Scanner input = new Scanner(System.in);
        
        // Getting user's first name.
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        
        // Getting user's second name.
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        
        // Getting user's age.
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        
        // Getting user's hours worked.
        System.out.print("Enter hours worked: ");
        double hoursWorked = input.nextDouble();
        
        // Getting user's hourly wage.
        System.out.print("Enter hourly wage: ");
        double hourlyWage = input.nextDouble();
    
        // Calculating the daily salary.
        double dailyWage = hoursWorked * hourlyWage;
        
        // Displaying the result or output.
        System.out.println("\nEmployee Information");
        System.out.println("---------------------");
        System.out.println("Full Name   : " + firstName + " " + lastName);
        System.out.println("Age         : " + age + " years old");
        System.out.printf("Daily Salary: PHP %.2f\n", dailyWage);
    }
}
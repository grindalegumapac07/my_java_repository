// Importing Scanner class from java package for user input.
import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2 {
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

        // Calculating user's years to retirement.
        int yearsToRetirement = Math.abs(65 - age);
    
        // Calculating user's daily wage.
        double dailyWage = hoursWorked * hourlyWage;

        // Rounding user's daily wage.
        double roundedDailyWage = Math.round(dailyWage);
        
        // Calculating user's weekly wage.
        double weeklyWage = roundedDailyWage * 5;
        
        // Calculating user's monthly wage.
        double monthlyWage = weeklyWage * 4;

        // Calculating user's gross yearly wage.
        double grossYearlyWage = monthlyWage * 12;

        // Calculating user's net yearly wage.
        double netYearlyWage = grossYearlyWage - (grossYearlyWage * 0.32) - 1500;

        // Displaying the result.
        System.out.println("\nEmployee Information");
        System.out.println("---------------------");
        System.out.println("Full Name:               " + lastName.toUpperCase() + ", " + firstName.toUpperCase());
        System.out.println("Age:                     " + age + " years old");
        System.out.println("Years to Retirement:     " + yearsToRetirement + " years");
        System.out.printf("Daily Salary:                     Php %.2f\n", dailyWage);
        System.out.printf("Weekly Salary:                    Php %.2f\n", weeklyWage);
        System.out.printf("Monthly Salary:                   Php %.2f\n", monthlyWage);
        System.out.printf("Gross Yearly Salary:              Php %.2f\n", grossYearlyWage);
        System.out.printf("Net Yearly Salary:                Php %.2f\n", netYearlyWage);
    }
}
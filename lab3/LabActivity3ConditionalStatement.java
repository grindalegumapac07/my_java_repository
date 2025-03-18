import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Getting user's basic information.
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        // Validating age.
        String validationMessage;
        if (age < 18 || age >= 65) {
            validationMessage = (age < 18) ? "Minors are not allowed" : "Senior Citizens are not allowed";
            System.out.println(validationMessage);
            return;     // finishes the execution of the program
        }

        // Calculating user's years to retirement.
        int yearsToRetirement = 65 - age;   // Using Math.abs() method is not necesarry since we can now catch for invalid inputs for age (a negative years to retirement value would be invalid).
        
        // Getting user's hours worked.
        System.out.print("Enter hours worked: ");
        double hoursWorked = input.nextDouble();

        // Validating hours worked.
        if (hoursWorked > 24 || hoursWorked <= 0) {
            validationMessage = (hoursWorked > 24) ? "Number of hours worked cannot exceed 24 hours" : "Wrong input on daily work hours";
            System.out.println(validationMessage);
            return;
        }
        
        // Getting user's hourly wage.
        System.out.print("Enter hourly wage: ");
        double hourlyWage = input.nextDouble();

        // Getting user's role.
        System.out.print("Enter your role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int roleCodeNumber = input.nextInt();
        
        // Determining role name using switch statement.
        String roleCodeName;
        switch (roleCodeNumber) {
            case 1:
                roleCodeName = "Manager"; 
                break;

            case 2:
                roleCodeName = "Supervisor"; 
                break;

            case 3:
                roleCodeName = "Staff"; 
                break;

            case 4:
                roleCodeName = "Intern"; 
                break;
        
            default:
                roleCodeName = "Undefined";
        }
    
        // Calculating user's wage.
        double dailyWage = hoursWorked * hourlyWage;
        double roundedDailyWage = Math.round(dailyWage);
        double weeklyWage = roundedDailyWage * 5;        
        double monthlyWage = weeklyWage * 4;
        double grossYearlyWage = monthlyWage * 12;

        // Calculating net yearly wage.
        double tax;
        double governmentBenefits = 1500;

        if (grossYearlyWage > 250000) {
            tax = grossYearlyWage * 0.32;
        } else {
            tax = 0;
        }

        double netYearlyWage = grossYearlyWage - tax - governmentBenefits;

        // Displaying the result.
        System.out.println("\nEmployee Information");
        System.out.println("---------------------");
        System.out.println("Full Name:              " + lastName.toUpperCase() + ", " + firstName.toUpperCase());
        System.out.println("Age:                    " + age + " years old");
        System.out.println("Position:               " + roleCodeName);
        System.out.println("Years to Retirement:    " + yearsToRetirement + " years");
        System.out.printf("Daily Salary:           Php %.2f\n", dailyWage);
        System.out.printf("Weekly Salary:          Php %.2f\n", weeklyWage);
        System.out.printf("Monthly Salary:         Php %.2f\n", monthlyWage);
        System.out.printf("Gross Yearly Salary:    Php %.2f\n", grossYearlyWage);
        System.out.printf("Net Yearly Salary:      Php %.2f\n", netYearlyWage);
    }
}

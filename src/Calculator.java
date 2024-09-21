import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        // Loop to continue calculations until the user decides to stop
        while (continueCalculating) {
            System.out.println("Enter the first number:");
            double num1 = getValidNumber(scanner);

            System.out.println("Enter the operator (+, -, *, /):");
            char operator = getValidOperator(scanner);

            System.out.println("Enter the second number:");
            double num2 = getValidNumber(scanner);

            // Perform the calculation
            double result = performOperation(num1, num2, operator);
            System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);

            // Ask if the user wants to continue
            System.out.println("Do you want to perform another calculation? (yes/no):");
            String response = scanner.next().toLowerCase();
            continueCalculating = response.equals("yes");
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    // Method to perform the chosen operation
    public static double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return Double.NaN; // Return 'Not a Number' if division by zero
                }
            default:
                System.out.println("Invalid operator.");
                return 0;
        }
    }

    // Method to validate numeric input
    public static double getValidNumber(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number:");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextDouble();
    }

    // Method to validate operator input
    public static char getValidOperator(Scanner scanner) {
        char operator = scanner.next().charAt(0);
        while (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            System.out.println("Invalid operator. Please enter one of (+, -, *, /):");
            operator = scanner.next().charAt(0);
        }
        return operator;
    }
}

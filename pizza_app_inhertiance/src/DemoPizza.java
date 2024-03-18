import java.util.Scanner;

public class DemoPizza {
    public static void main(String[] args) {
        // Quit Constant
        final String QUIT = "QUIT";
        System.out.println("Welcome to my Pizza application, enter your preferred toppings (up to 10) or type " + QUIT + " to stop anytime");

        Scanner scanner = new Scanner(System.in);
        String[] toppings = new String[10];
        int num_toppings = 0;
        String input;

        while (num_toppings < 10) {
            input = scanner.nextLine();

            // Repeat the process if the user enters an empty string
            if (input.equalsIgnoreCase("")) {
                System.out.println("Please enter a topping");
                continue;
            }

            if (input.equalsIgnoreCase(QUIT)) {
                // Repeat if the user enters QUIT with no toppings
                if (num_toppings == 0) {
                    System.out.println("Please enter a topping");
                    continue;
                }
                break;
            }
            toppings[num_toppings++] = input;

        }
        // Handle delivery status
        System.out.print("Is the pizza to be delivered? (yes/no): ");
        input = scanner.nextLine();
        while (true) {
            if (input.equalsIgnoreCase("yes")) {
                System.out.print("Enter delivery address: ");
                String deliveryAddress = scanner.nextLine();
                if (deliveryAddress.equalsIgnoreCase("")) {
                    System.out.println("Please enter an address");
                    continue;
                }
                // Create deliverypizza object and display to the user
                DeliveryPizza pizza = new DeliveryPizza(toppings, deliveryAddress, num_toppings);
                System.out.println("\nPizza Details:\n" + pizza);
                break;
            } else {
                // Create pizza object and display to the user
                Pizza pizza = new Pizza(toppings, num_toppings);
                System.out.println("\nPizza Details:\n" + pizza);
                break;
            }
        }


    }
}

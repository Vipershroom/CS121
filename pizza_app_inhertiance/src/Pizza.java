import java.util.Arrays;
public class Pizza {
    String[] toppings;
    private double price;

    public Pizza(String[] toppings, int toppings_num) {
        // Initialize the string array and topings
        this.toppings = new String[toppings_num];
        for (int i = 0; i < toppings_num; i++) {
            this.toppings[i] = toppings[i];
        }

        // Build the string array with toppings using a StringBuilder
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < toppings_num - 1; i++) {
            description.append(toppings[i]).append(", ");
        }

        // Set every price to $14 plus 2 for each topping.
        description.append(toppings[toppings_num - 1]);
        this.price = 14 + (2 * toppings_num);
    }

    // Adds to string method, @Override is to override the existing toString method.
    @Override
    public String toString() {
        return "Pizza with toppings: " + Arrays.toString(toppings) + "\nPrice: $" + price;
    }

    // Gets the current price of the Pizza object
    public double getPrice() {
        return price;
    }
}

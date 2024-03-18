public class DeliveryPizza extends Pizza {
    private double delivery_fee;
    private String delivery_address;

    public DeliveryPizza(String[] toppings, String delivery_address, int num_toppings) {
        // Initialize Parent classes constructor
        super(toppings, num_toppings);

        // Handle delivery fee
        this.delivery_address = delivery_address;
        if (super.getPrice() > 18) {
            this.delivery_fee = 3;
        } else {
            this.delivery_fee = 5;
        }
        }
    }


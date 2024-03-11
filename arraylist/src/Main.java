public class Main {
    public static void main(String[] args) {
        // Testing area
        Item tissue = new Item("Tissue", 3.0);


        ItemOrder tissueOrder1 = new ItemOrder(tissue, 5);
        ItemOrder tissueOrder2 = new ItemOrder(tissue, 3);


        ShoppingCart cart = new ShoppingCart();

        cart.addItem(tissueOrder1);
        cart.addItem(tissueOrder2);

        double totalPrice = cart.getTotalPrice();
        System.out.println("Total price: $" + totalPrice);
    }
}
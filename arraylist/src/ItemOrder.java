public class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        // Add a threshold discount of 2
        int bulkDiscount = 2;
        double bulkDiscountPrice = 4.0;

        // Use division and remainders to find the price
        if (quantity >= bulkDiscount) {
            int bulkCount = quantity / bulkDiscount;
            int remainder = quantity % bulkDiscount;
            totalPrice += bulkCount * bulkDiscountPrice;
            totalPrice += remainder * item.getPrice();
        } else {
            totalPrice = item.getPrice() * quantity;
        }
        return totalPrice;
    }

    public Item getItem() {
        return item;
    }
}

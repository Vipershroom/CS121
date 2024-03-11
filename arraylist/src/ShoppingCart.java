import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

class ShoppingCart {
    private ArrayList<ItemOrder> itemList;

    public ShoppingCart() {
        itemList = new ArrayList<>();
    }

    public void addItem(ItemOrder itemOrder) {
        itemList.add(itemOrder);
    }

    public void removeItem(ItemOrder itemOrder) {
        itemList.remove(itemOrder);
    }

    public ItemOrder searchItem(String itemName) {
        for (ItemOrder itemOrder : itemList) {
            if (itemOrder.getItem().getName().equalsIgnoreCase(itemName)) {
                return itemOrder;
            }
        }
        return null;
    }

    public double getTotalPrice() {
        // Convert to a list to use the map method
        List<Double> itemOrderList = ((List<ItemOrder>) itemList).stream().map(ItemOrder::getTotalPrice).toList();
        return itemOrderList.stream().mapToDouble(Double::doubleValue).sum();

    }
}
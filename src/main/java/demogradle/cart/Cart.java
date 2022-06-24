package demogradle.cart;

import demogradle.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart()
    {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item)
    {
        double totalAmount = getTotalPrice() + item.getPrice();

        if(totalAmount > 100.00)
        {
            throw new IllegalArgumentException("Total amount of items must be less than 100.00");
        }

        this.items.add(item);
    }

    public double getTotalPrice()
    {
        double total = 0.0;

        for (Item items : this.items)
        {
            total += items.getPrice();
        }

        return total;
    }

    public double getPurchasePossibility()
    {
        return 100 - getTotalPrice();
    }

    public List<Item> getItems() {
        return items;
    }
}

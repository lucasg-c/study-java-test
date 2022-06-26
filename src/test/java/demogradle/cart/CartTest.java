package demogradle.cart;

import demogradle.item.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest {

    Cart cart;

    @BeforeEach
    public void testSetup()
    {
        cart = new Cart();
    }

    @Test
    public void getTotalPrice()
    {
        double total = 0.0;
        cart.addItem(new Item("Batata", 5.50));
        cart.addItem(new Item("Arroz", 10.20));
        cart.addItem(new Item("Banana", 2.30));

        total = cart.getTotalPrice();

        Assertions.assertNotEquals(0.0, total);
        Assertions.assertEquals(18.00, total);
    }

    @Test
    public void addItem()
    {
        Item item = new Item("Batata", 5.50);

        cart.addItem(item);

        Assertions.assertDoesNotThrow(() -> {
            cart.addItem(item);
        });
        Assertions.assertFalse(cart.getItems().isEmpty());
        Assertions.assertEquals(2, cart.getItems().size());
    }

    @Test
    public void addItem_ThrowsException_WhenTotalAmountExceedsAHundred()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem(new Item("Batata", 100.50));
        });
    }

    @Test
    public void getPurchasePossibility()
    {
        double purchasePossibility = 0.0;
        cart.addItem(new Item("Batata", 25.50));
        cart.addItem(new Item("Arroz", 14.50));

        purchasePossibility = cart.getPurchasePossibility();

        Assertions.assertEquals(60.00, purchasePossibility);
    }
}

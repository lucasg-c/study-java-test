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
        //Arrange
        double total = 0.0;
        cart.addItem(new Item("Batata", 5.50));
        cart.addItem(new Item("Arroz", 10.20));
        cart.addItem(new Item("Banana", 2.30));

        //Act
        total = cart.getTotalPrice();

        //Assert
        Assertions.assertNotEquals(0.0, total);
        Assertions.assertEquals(18.00, total);
    }

    @Test
    public void addItem()
    {
        //Act
        cart.addItem(new Item("Batata", 5.50));

        //Assert
        Assertions.assertFalse(cart.getItems().isEmpty());
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
        //Arrange
        double purchasePossibility = 0.0;
        cart.addItem(new Item("Batata", 25.50));
        cart.addItem(new Item("Arroz", 14.50));

        //Act
        purchasePossibility = cart.getPurchasePossibility();

        //Assert
        Assertions.assertEquals(60.00, purchasePossibility);
    }
}

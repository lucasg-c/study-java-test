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

        cart.addItem(new Item("Batata", 5.50));
        cart.addItem(new Item("Arroz", 10.20));
        cart.addItem(new Item("Banana", 2.30));
    }

    @Test
    public void getTotalPrice()
    {
        //Arrange
        double total = 0.0;
        System.out.println("teste");

        //Act
        total = cart.getTotalPrice();

        //Assert
        Assertions.assertNotEquals(0.0, total);
    }
}

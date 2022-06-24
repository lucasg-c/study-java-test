package demogradle;

import demogradle.cart.Cart;
import demogradle.item.Item;

public class App {
    public String getGreeting()
    {
        return "Hello, world.";
    }

    public static void main(String[] args)
    {
        System.out.println(new App().getGreeting());

        Cart carrinho = new Cart();

        Item item1 = new Item("Batata", 5.50);
        Item item2 = new Item("Arroz", 10.20);
        Item item3 = new Item("Banana", 2.30);
        Item item4 = new Item("Batata Doce", 82.00);

        carrinho.addItem(item1);
        carrinho.addItem(item2);
        carrinho.addItem(item3);
        carrinho.addItem(item4);

        System.out.println(carrinho.getTotalPrice());
        System.out.println(carrinho.getPurchasePossibility());
    }
}

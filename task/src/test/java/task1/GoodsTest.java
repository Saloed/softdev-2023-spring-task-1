package task1;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsTest {
    @Test
    public void testCost() {
        Goods.addProduct("Молоко", 50.0, 1);
        Goods.addProduct("Газировка", 15.0, 2);
        List<ProdPair> shoppingList = new ArrayList<>();
        shoppingList.add(new ProdPair(1, 5));
        shoppingList.add(new ProdPair(2, 2));
        double expectedPrice = 280.0;
        assertEquals(expectedPrice, Goods.priceForAmount(shoppingList));
    }
    @Test
    public void testCostAfterPriceChange() {
        Goods.addProduct("Молоко", 50.0, 1);
        Goods.addProduct("Газировка", 15.0, 2);
        Goods.changePrice(1, 100.0);
        Goods.changePrice(2, 30.0);
        List<ProdPair> shoppingList = new ArrayList<>();
        shoppingList.add(new ProdPair(1, 5));
        double expectedPrice = 500.0;
        assertEquals(expectedPrice, Goods.priceForAmount(shoppingList));
    }
    @Test
    public void testCostInvalidCode() {
        Goods.addProduct("Молоко", 50.0, 1);
        Goods.addProduct("Газировка", 15.0, 2);
        Goods.changePrice(1, 100.0);
        Goods.changePrice(2, 30.0);
        List<ProdPair> shoppingList = new ArrayList<>();
        shoppingList.add(new ProdPair(3, 5));
        assertThrows(IllegalArgumentException.class, () -> Goods.priceForAmount(shoppingList));
    }
    @Test
    public void testChangeName() {
        Goods.addProduct("Молоко", 50.0, 1);
        Goods.addProduct("Газировка", 15.0, 2);
        Goods.changeName(1, "Milk");
        assertEquals("Milk", Goods.goodsList.get(1).getName());
    }
    @Test
    public void testChangeNameInvalidCode() {
        Goods.addProduct("Молоко", 50.0, 1);
        Goods.addProduct("Газировка", 15.0, 2);
        assertThrows(IllegalArgumentException.class, () -> Goods.changeName(3, "Milk"));
    }
    @Test
    public void testProductRemoval() {
        Goods.addProduct("Молоко", 50.0, 1);
        Goods.addProduct("Газировка", 15.0, 2);
        List<ProdPair> shoppingList = new ArrayList<>();
        shoppingList.add(new ProdPair(1, 5));
        Goods.removeGoods(1);
        assertNull(Goods.goodsList.get(1));
        assertThrows(IllegalArgumentException.class, () -> Goods.priceForAmount(shoppingList));
    }
}

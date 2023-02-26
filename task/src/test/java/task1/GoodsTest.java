package task1;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsTest {
    @Test
    public void testCost() {
        Goods goodsList = new Goods();
        goodsList.addProduct("Молоко", 50.0, 1);
        goodsList.addProduct("Газировка", 15.0, 2);
        List<ProdPair> shoppingList = new ArrayList<>();
        shoppingList.add(new ProdPair(1, 5));
        shoppingList.add(new ProdPair(2, 2));
        double expectedPrice = 280.0;
        assertEquals(expectedPrice, goodsList.priceForAmount(shoppingList));
    }

    @Test
    public void testCostAfterPriceChange() {
        Goods goodsList = new Goods();
        goodsList.addProduct("Молоко", 50.0, 1);
        goodsList.addProduct("Газировка", 15.0, 2);
        goodsList.changePrice(1, 100.0);
        goodsList.changePrice(2, 30.0);
        List<ProdPair> shoppingList = new ArrayList<>();
        shoppingList.add(new ProdPair(1, 5));
        double expectedPrice = 500.0;
        assertEquals(expectedPrice, goodsList.priceForAmount(shoppingList));
    }

    @Test
    public void testCostInvalidCode() {
        Goods goodsList = new Goods();
        goodsList.addProduct("Молоко", 50.0, 1);
        goodsList.addProduct("Газировка", 15.0, 2);
        goodsList.changePrice(1, 100.0);
        goodsList.changePrice(2, 30.0);
        List<ProdPair> shoppingList = new ArrayList<>();
        shoppingList.add(new ProdPair(3, 5));
        assertThrows(IllegalArgumentException.class, () -> goodsList.priceForAmount(shoppingList));
    }

    @Test
    public void testChangeNameInvalidCode() {
        Goods goodsList = new Goods();
        goodsList.addProduct("Молоко", 50.0, 1);
        goodsList.addProduct("Газировка", 15.0, 2);
        assertThrows(IllegalArgumentException.class, () -> goodsList.changeName(3, "Milk"));
    }

    @Test
    public void testProductRemoval() {
        Goods goodsList = new Goods();
        goodsList.addProduct("Молоко", 50.0, 1);
        goodsList.addProduct("Газировка", 15.0, 2);
        List<ProdPair> shoppingList = new ArrayList<>();
        shoppingList.add(new ProdPair(2, 5));
        goodsList.removeGoods(2);
        assertThrows(IllegalArgumentException.class, () -> goodsList.priceForAmount(shoppingList));
        shoppingList.clear();
        shoppingList.add(new ProdPair(1, 10));
        assertEquals(500.0, goodsList.priceForAmount(shoppingList));
    }
}

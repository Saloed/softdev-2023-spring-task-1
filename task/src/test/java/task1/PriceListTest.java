package task1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PriceListTest {
    @Test
    void appAddsProducts() {
        PriceList priceList = new PriceList();
        assertTrue(priceList.addProduct(100.1, new Product("Milk 3.2%", 1005695)));
        assertFalse(priceList.addProduct(100.1, new Product("Milk 3.2%", 1005695)));
        assertTrue(priceList.addProduct(115.1, new Product("Water 5l", 1064595)));
        assertTrue(priceList.addProduct(195.1, new Product("Olive oil 0.9l", 106465468)));

    }

    @Test
    void appChangePriceProducts() {
        PriceList priceList = new PriceList();
        assertTrue(priceList.addProduct(100.1, new Product("Cake 1kg", 1246695)));
        assertTrue(priceList.addProduct(214.21, new Product("Chicken Meat", 11245531)));
        assertTrue(priceList.addProduct(195.1, new Product("Potato 1,1 kg", 106135798)));
        assertTrue(priceList.changePrice(new Product("Cake 1kg", 1246695), 121.12));
        assertFalse(priceList.changePrice(new Product("Milk 3.2%", 1005695), 100.1));

    }

    @Test
    void appChangeProductName() {
        PriceList priceList = new PriceList();
        assertTrue(priceList.addProduct(100.1, new Product("Milk 3.2%", 1005695)));
        assertFalse(priceList.addProduct(100.1, new Product("Milk 3.2%", 1005695)));
        assertTrue(priceList.addProduct(115.1, new Product("Water 5l", 1064595)));
        assertTrue(priceList.addProduct(195.1, new Product("Olive oil 0.9l", 106465468)));
        assertTrue(priceList.changeProductName(new Product("Olive oil 0.9l", 106465468), "Olive Oil Extra 0.9l"));
        assertFalse(priceList.changeProductName(new Product("Potato Russia 1,1 kg", 106135798), "Potato Belarus 1,1 kg"));
    }

    @Test
    void appDeleteProduct() {
        PriceList priceList = new PriceList();
        assertTrue(priceList.addProduct(100.1, new Product("Milk 3.2%", 1005695)));
        assertFalse(priceList.addProduct(100.1, new Product("Milk 3.2%", 1005695)));
        assertTrue(priceList.addProduct(115.1, new Product("Water 5l", 1064595)));
        assertTrue(priceList.addProduct(195.1, new Product("Olive oil 0.9l", 106465468)));
        assertTrue(priceList.deleteProduct(new Product("Olive oil 0.9l", 106465468)));
        assertFalse(priceList.deleteProduct(new Product("Olive oil 0.9l", 106465468)));
        assertFalse(priceList.deleteProduct(new Product("Potato Russia 1,1 kg", 106135798)));
    }
    @Test
    void appProductCost() {
        PriceList priceList = new PriceList();
        assertTrue(priceList.addProduct(100.11, new Product("Milk 3.2%", 1005695)));
        assertFalse(priceList.addProduct(100.1, new Product("Milk 3.2%", 1005695)));
        assertTrue(priceList.addProduct(115.1, new Product("Water 5l", 1064595)));
        assertTrue(priceList.addProduct(195.1, new Product("Olive oil 0.9l", 106465468)));
        assertEquals(300.33,priceList.cost(1005695, 3), 1e-3);
        assertEquals(585.3,priceList.cost(106465468, 3),1e-3);
    }

}


package task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PriceListTest {
    PriceMap priceMapTest = new PriceMap();
    //имена
    String firstNameProduct = "Хлеб";
    String secondNameProduct = "Масло";
    String thirdNameProduct = "Вода";
    String fourthNameProduct = "Молоко";
    String firstWrongNameProduct = "Коки-Кола";
    String secondWrongNameProduct = "Чипсеки";
    //цены
    Double firstPriceProduct = 10.0;
    Double secondPriceProduct = 24.99;
    Double thirdPriceProduct = 5.05;
    Double fourthPriceProduct = 34.99;
    Double firstWrongPriceProduct = -100.00;
    Double secondWrongPriceProduct = 99.999;
    //коды
    int firstCodeProduct = 1;
    int secondCodeProduct = 2;
    int thirdCodeProduct = 3;
    int fourthCodeProduct = 4;
    int fifthCodeProduct = 5;
    int firstWrongCodeProduct = 6;
    int secondWrongCodeProduct = 7;


    @BeforeAll
    public void startProducts() {
        priceMapTest.addProduct(firstCodeProduct, firstNameProduct, firstPriceProduct);
        priceMapTest.addProduct(secondCodeProduct, secondNameProduct, secondPriceProduct);
        priceMapTest.addProduct(thirdCodeProduct, thirdNameProduct, thirdPriceProduct);
        priceMapTest.addProduct(fourthCodeProduct, fourthNameProduct, fourthPriceProduct);
    }

    @Test
    public void addProductTest() {
        assertTrue(priceMapTest.mapOfProduct.containsKey(firstCodeProduct));
        assertTrue(priceMapTest.mapOfProduct.containsKey(1));
        assertFalse(priceMapTest.mapOfProduct.containsKey(45));
        assertFalse(priceMapTest.mapOfProduct.containsKey(fifthCodeProduct));
        assertThrows(IllegalArgumentException.class, () -> priceMapTest.addProduct(firstWrongCodeProduct, firstWrongNameProduct, firstWrongPriceProduct));
        assertThrows(IllegalArgumentException.class, () -> priceMapTest.addProduct(secondWrongCodeProduct, secondWrongNameProduct, secondWrongPriceProduct));
    }

    @Test
    public void removeProductTest() {
        priceMapTest.removeProductOnCode(firstCodeProduct);
        assertFalse(priceMapTest.mapOfProduct.containsKey(firstCodeProduct));
        assertThrows(NoSuchElementException.class, () -> priceMapTest.removeProductOnCode(213));
    }

    @Test
    public void changeNameOnCodeTest() {
        priceMapTest.changeNameOnCode(firstCodeProduct, "Торт");
        assertEquals("Торт", priceMapTest.mapOfProduct.get(firstCodeProduct).getName());
        assertThrows(NoSuchElementException.class, () -> priceMapTest.changeNameOnCode(23, "бвбвбвбвб"));
    }

    @Test
    public void changePriceOnCodeTest() {
        priceMapTest.changePriceOnCode(firstCodeProduct, 100.23);
        assertEquals(100.23, priceMapTest.mapOfProduct.get(firstCodeProduct).getPrice());
        assertThrows(NoSuchElementException.class, () -> priceMapTest.changePriceOnCode(213, 123.24));
    }

    @Test
    public void getNameOnCodeTest() {
        assertEquals("Вода", priceMapTest.getNameOnCode(thirdCodeProduct));
        assertThrows(NoSuchElementException.class, () -> priceMapTest.getNameOnCode(31));
    }

    @Test
    public void getPriceOnCodeTest() {
        assertEquals(24.99, priceMapTest.getPriceOnCode(secondCodeProduct));
        assertThrows(NoSuchElementException.class, () -> priceMapTest.getPriceOnCode(13));
    }

    @Test
    public void totalCostTest() {
        List<PriceMap.Pair> testList = List.of(new PriceMap.Pair(firstCodeProduct, 1), new PriceMap.Pair(secondCodeProduct, 3),
                new PriceMap.Pair(thirdCodeProduct, 10), new PriceMap.Pair(fourthCodeProduct, 2));
        assertEquals("Суммарная стоимость всех товаров: 205 рублей 45 копеек", priceMapTest.totalCost(testList));
    }
}
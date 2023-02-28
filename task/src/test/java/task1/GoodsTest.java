package task1;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsTest {
    private static ProductList ProdList;
    static List<ProductList.ProdPair> shoppingList;

    @BeforeEach
    public void setUp() {
        ProdList = new ProductList();
        shoppingList = new ArrayList<>();
        ProdList.addProduct("Молоко", 55.00, 1);
        ProdList.addProduct("Газировка", 90.00, 2);
        ProdList.addProduct("Хлеб", 52.00, 3);
        ProdList.addProduct("Ручка", 15.00, 4);
        ProdList.addProduct("Носок", 30.00, 5);
        ProdList.addProduct("Пара классных носков", 200.00, 6);
        shoppingList.add(new ProductList.ProdPair(1, 2));
        shoppingList.add(new ProductList.ProdPair(2, 1));
        shoppingList.add(new ProductList.ProdPair(3, 5));
    }

    @Test
    void addProductTests() {
        //Успешные тесты
        ProdList.addProduct("Огурец", 15.99, 99);
        assertEquals("Огурец", ProdList.getProdName(99));
        assertEquals(15.99, ProdList.getProdPrice(99));
        //Тесты ошибок
        assertThrows(IllegalArgumentException.class, () -> ProdList.addProduct("Огурец", 129.999, 8)); // Не верный формат цены
        assertThrows(IllegalArgumentException.class, () -> ProdList.addProduct("Огурец", 129.99, -1)); // Не валидный код
        assertThrows(IllegalArgumentException.class, () -> ProdList.addProduct("Огурец", 100.00, 1)); // Код уже занят
        assertThrows(IllegalArgumentException.class, () -> ProdList.addProduct("Огурец", -129.99, 9)); // Отрицательная цена
    }

    @Test
    void removeProductTests() {
        ProdList.removeProduct(1);
        assertThrows(NoSuchElementException.class, () -> ProdList.removeProduct(1)); //Такого товара больше нет
        assertThrows(NoSuchElementException.class, () -> ProdList.getProdName(1)); //Такого товара больше нет
        assertThrows(NoSuchElementException.class, () -> ProdList.getProdPrice(1)); //Такого товара больше нет
        assertThrows(NoSuchElementException.class, () -> ProdList.removeProduct(10)); //Такого товара нет
    }

    @Test
    void changeNameAndPriceTests() {
        //Успешные тесты
        ProdList.changePrice(1, 31.00);
        ProdList.changeName(1, "Ещё носок, но на рубль дороже");
        assertEquals(31.00, ProdList.getProdPrice(1));
        assertEquals("Ещё носок, но на рубль дороже", ProdList.getProdName(1));
        //Тесты ошибок
        assertThrows(NoSuchElementException.class, () -> ProdList.changeName(10, "Огурец")); // Такого товара нет
        assertThrows(NoSuchElementException.class, () -> ProdList.changePrice(10, 10.0)); // Такого товара всё ещё нет!
        assertThrows(IllegalArgumentException.class, () -> ProdList.changePrice(1, -10.0)); // Отрицательная цена
        assertThrows(IllegalArgumentException.class, () -> ProdList.changePrice(1, 10.999)); // Не верный формат цены
    }

    @Test
    void priceForAmountTests() {
        //Тест с результатом
        assertEquals(460.0, ProdList.priceForAmount(shoppingList));
        //Тест ошибки
        shoppingList.add(new ProductList.ProdPair(10, 5));
        assertThrows(NoSuchElementException.class, () -> ProdList.priceForAmount(shoppingList)); // Несуществующий товар
    }
}

package task1;

import java.util.*;


public class Goods {
    static TreeMap<Integer, Goods> goodsList = new TreeMap<>();
    private final String name;
    private final Double price; // Цена указывается числом через запятую

    Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    static void addProduct(String name, Double price, int code) { // Добавляет новый продукт с именем, ценой и кодом
        Goods prod = new Goods(name, price);
        goodsList.put(code, prod);
    }

    public static void changePrice(int code, Double price) { // Меняет цену продукта по его коду
        if (goodsList.containsKey(code)) {
            Goods obj = new Goods(goodsList.get(code).getName(), price);
            goodsList.put(code, obj);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void changeName(int code, String name) { // Меняет имя продукта подобно смене цены
        if (goodsList.containsKey(code)) {
            Goods obj = new Goods(name, goodsList.get(code).getPrice());
            goodsList.put(code, obj);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static public void removeGoods(int code) { // Удаляет продукт по его коду
        if (goodsList.containsKey(code)) {
            goodsList.remove(code);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Double priceForAmount(List<ProdPair> shoppingList) {
        double fin = 0.0;
        for (ProdPair intPair : shoppingList) {
            if (goodsList.containsKey(intPair.code())) {
                fin += goodsList.get(intPair.code()).getPrice() * intPair.amount();
            } else {
                throw new IllegalArgumentException();
            }
        }
        return fin;
    }
}


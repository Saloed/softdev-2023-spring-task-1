package task1;

import java.util.*;


public class Goods {
    private final Map<Integer, Goods> goodsList = new HashMap<>();
    private String name;
    private Double price; // Цена указывается числом через запятую

    Goods() {
        name = "Undefined";
        price = 0.0;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    void addProduct(String name, Double price, int code) { // Добавляет новый продукт с именем, ценой и кодом
        Goods prod = new Goods(name, price);
        goodsList.put(code, prod);
    }

    public void changePrice(int code, Double price) { // Меняет цену продукта по его коду
        if (goodsList.containsKey(code)) {
            goodsList.get(code).setPrice(price);
        } else {
            throw new IllegalArgumentException("Invalid code");
        }
    }

    public void changeName(int code, String name) { // Меняет имя продукта подобно смене цены
        if (goodsList.containsKey(code)) {
            goodsList.get(code).setName(name);
        } else {
            throw new IllegalArgumentException("Invalid code");
        }
    }

    public void removeGoods(int code) { // Удаляет продукт по его коду
        if (goodsList.containsKey(code)) {
            goodsList.remove(code);
        } else {
            throw new IllegalArgumentException("Invalid code");
        }
    }

    public Double priceForAmount(List<ProdPair> shoppingList) {
        double fin = 0.0;
        for (ProdPair intPair : shoppingList) {
            if (goodsList.containsKey(intPair.code())) {
                fin += goodsList.get(intPair.code()).getPrice() * intPair.amount();
            } else {
                throw new IllegalArgumentException("Invalid code");
            }
        }
        return fin;
    }
}


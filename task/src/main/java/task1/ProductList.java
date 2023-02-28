package task1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ProductList {
    private Map<Integer, Product> goodsList = new HashMap<>();

    ProductList() {
    }

    public void addProduct(String name, Double price, int code) { // Добавляет новый продукт с именем, ценой и кодом
        if (code < 0) {
            throw new IllegalArgumentException("Code should be a positive number");
        }
        if (goodsList.containsKey(code)) {
            throw new IllegalArgumentException("Code has already been added, try another one");
        }
        Product prod = new Product(name, price);
        goodsList.put(code, prod);
    }

    public void changePrice(int code, Double price) { // Меняет цену продукта по его коду
        if (goodsList.containsKey(code)) {
            goodsList.get(code).setPrice(price);
        } else {
            throw new NoSuchElementException("This product doesn't exist");
        }
    }

    public void changeName(int code, String name) { // Меняет имя продукта подобно смене цены
        if (goodsList.containsKey(code)) {
            goodsList.get(code).setName(name);
        } else {
            throw new NoSuchElementException("This product doesn't exist");
        }
    }

    public void removeProduct(int code) { // Удаляет продукт по его коду
        if (goodsList.containsKey(code)) {
            goodsList.remove(code);
        } else {
            throw new NoSuchElementException("This product doesn't exist");
        }
    }

    public Double priceForAmount(List<ProdPair> shoppingList) {
        double fin = 0.0;
        for (ProdPair intPair : shoppingList) {
            if (!goodsList.containsKey(intPair.code())) {
                throw new NoSuchElementException("This product doesn't exist");
            }
            if (intPair.amount < 0) {
                throw new IllegalArgumentException("A product in your list shouldn't have a negative amount number");
            }
            fin += goodsList.get(intPair.code()).getPrice() * intPair.amount();
        }
        return fin;
    }

    public String getProdName(int code) {
        if (code < 0) {
            throw new IllegalArgumentException("Code should be a positive number");
        }
        if (!goodsList.containsKey(code)) {
            throw new NoSuchElementException("This product doesn't exist");
        }
        return goodsList.get(code).getName();
    }

    public Double getProdPrice(int code) {
        if (code < 0) {
            throw new IllegalArgumentException("Code should be a positive number");
        }
        if (!goodsList.containsKey(code)) {
            throw new NoSuchElementException("This product doesn't exist");
        }
        return goodsList.get(code).getPrice();
    }


    private class Product {
        private String name;
        private Double price; // Цена указывается числом через запятую

        Product(String name, Double price) {
            this.name = name;
            if (price.toString().split("\\.")[1].length() > 2) {
                throw new IllegalArgumentException("There shouldn't be more than 2 digits after the decimal point");
            }
            if (price < 0.0) {
                throw new IllegalArgumentException("Price shouldn't be negative");
            } else this.price = price;
        }

        private String getName() {
            return name;
        }

        private Double getPrice() {
            return price;
        }

        private void setName(String name) {
            this.name = name;
        }

        private void setPrice(Double price) {
            if (price.toString().split("\\.")[1].length() > 2) {
                throw new IllegalArgumentException("There shouldn't be more than 2 digits after the decimal point");
            }
            if (price < 0.0) {
                throw new IllegalArgumentException("Price shouldn't be negative");
            } else this.price = price;
        }

    }

    public record ProdPair(int code, int amount) {
    }
}

package task1;

import java.util.*;

public class PriceMap {
    public PriceMap() {
        mapOfProduct = new HashMap<>();
    }

     public Map<Integer, Product> mapOfProduct;

    public void addProduct(int codeUser, String nameUser, Double priceUser) {
        if (mapOfProduct.containsKey(codeUser))
            throw new IllegalArgumentException("Товар с таким кодом уже существует!");
        if (priceUser < 0.0) throw new IllegalArgumentException("Цена не может быть отрицательной!");
        String[] timeSplitPrice = priceUser.toString().split("\\.");
        if (timeSplitPrice[1].length() > 2)
            throw new IllegalArgumentException("Копейки должны занимать не больше 2-х знаков!");
        mapOfProduct.put(codeUser, new Product(nameUser, priceUser));
    }

    public void removeProductOnCode(int codeUser) {
        if (!mapOfProduct.containsKey(codeUser)) throw new NoSuchElementException("Товара с таким кодом не существует!");
        mapOfProduct.remove(codeUser);
    }

    public void changeNameOnCode(int codeUser, String nameUser) {
        if (!mapOfProduct.containsKey(codeUser)) throw new NoSuchElementException("Товара с таким кодом не существует!");
        mapOfProduct.get(codeUser).setName(nameUser);
    }

    public void changePriceOnCode(int codeUser, Double priceUser) {
        if (!mapOfProduct.containsKey(codeUser)) throw new NoSuchElementException("Товара с таким кодом не существует!");
        mapOfProduct.get(codeUser).setPrice(priceUser);
    }

    public String getNameOnCode(int codeUser) {
        if (!mapOfProduct.containsKey(codeUser)) throw new NoSuchElementException("Товара с таким кодом не существует!");
        return mapOfProduct.get(codeUser).getName();
    }

    public Double getPriceOnCode(int codeUser) {
        if (!mapOfProduct.containsKey(codeUser)) throw new NoSuchElementException("Товара с таким кодом не существует!");
        return mapOfProduct.get(codeUser).getPrice();
    }

    public String totalCost(List<Pair> listOfPairs) {
        double sum = 0.0;
        for (Pair currentPair : listOfPairs) {
            int currentCode = currentPair.codeuser();
            int currentAmount = currentPair.amount();
            if (!mapOfProduct.containsKey(currentCode))
                throw new IllegalArgumentException("Товара с таким кодом не существует!");
            if (currentAmount < 0) throw new IllegalArgumentException("Количество товара должно быть неотрицательным!");
            sum += mapOfProduct.get(currentCode).getPrice() * currentAmount;
        }
        String[] strSum = String.valueOf(sum).split("\\.");
        int rubles = Integer.parseInt(strSum[0]);
        int pennies = Integer.parseInt(strSum[1]);
        return String.format("Суммарная стоимость всех товаров: %s рублей %02d копеек", rubles, pennies);
    }


    public record Pair(int codeuser, int amount) {
    }
}





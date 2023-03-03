package task1;

import java.util.LinkedHashMap;
import java.util.Map;

public class PriceList {
    Map<Product, Double> prices = new LinkedHashMap<>();

    public boolean addProduct(Double price, Product product) {
        if (prices.containsKey(getByCode(product.getCode()))) return false;
        prices.put(product, price);
        return true;
    }


    public boolean changePrice(Product product,Double newPrice) {
        if (!prices.containsKey(getByCode(product.getCode()))) return false;
        prices.replace(product, prices.get(getByCode(product.getCode())), newPrice);
        return true;
    }

    public boolean changeProductName(Product product, String newName) {
        if (!prices.containsKey(getByCode(product.getCode()))) return false;
        Product nnProd = new Product(newName, product.code);
        prices.put(nnProd, prices.get(getByCode(product.getCode())));
        prices.remove(getByCode(product.getCode()));
        return true;
    }

    public boolean deleteProduct(Product product) {
        if (!prices.containsKey(getByCode(product.getCode()))) return false;
        prices.remove(getByCode(product.getCode()));
        return true;
    }

    public double cost(int pcode, int count) {
        return prices.get(getByCode(pcode)) * count;

    }

    public Product getByCode(int code) {
        for (Product product : prices.keySet()) {
            if (product.getCode() == code) return product;
        }
        return null;
    }


}

class Product {
    String name;
    int code;

    public Product(String name, int code) {
        this.name = name;
        this.code = code;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return code == product.code && name.equals(product.name);
    }
}


package task1;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class PriceList {
    Map<Product, BigDecimal> prices = new LinkedHashMap<>();

    public boolean addProduct(BigDecimal price, Product product) {
        if (prices.containsKey(getByCode(product.getCode()))) return false;
        prices.put(product, price);
        return true;
    }


    public boolean changePrice(Product product, BigDecimal newPrice) {
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

    public BigDecimal cost(int pcode, int count) {
        return prices.get(getByCode(pcode)).multiply(BigDecimal.valueOf(count));

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
        return name.hashCode() + code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;

        return code == product.code && name.equals(product.name);
    }
}


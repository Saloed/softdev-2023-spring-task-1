package task1;

public class Product {
    private String name;
    private Double price;

    public Product(String nameUser, Double priceUser) {
        this.name = nameUser;
        this.price = priceUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}

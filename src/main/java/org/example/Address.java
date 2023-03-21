package org.example;

public class Address {
    private String street;
    private int home;
    private int flat;

    public Address(String street, int home, int flat) {
        this.street = street;
        this.home = home;
        this.flat = flat;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getFlat() {
        return flat;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", home=" + home +
                ", flat=" + flat +
                '}';
    }
}

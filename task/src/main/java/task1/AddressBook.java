package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Address {
    public String street;
    public int house;
    public int apartment;

    Address(String street, int house, int apartment) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }
}

public class AddressBook {

    public Map<String, Address> book = new HashMap<String, Address>();

    public void addAddress(Address address, String surName) {
        book.put(surName, address);
    }

    public void removePerson(String surName) {
        book.remove(surName);
    }

    public Address getAddress(String surName) {
        return book.get(surName);
    }

    public void changeAddress(Address address, String surName) {
        book.replace(surName, address);
    }

    public List<String> getPeopleOnStreet(String street) {
        List<String> peopleOnStreet = new ArrayList<String>();
        book.entrySet().stream()
                .filter(e -> e.getValue().street.equals(street))
                .forEach(e -> peopleOnStreet.add(e.getKey()));
        return peopleOnStreet;
    }

    public List<String> getPeopleInHouse(String street, int house) {
        List<String> peopleInHouse = new ArrayList<String>();
        book.entrySet().stream()
                .filter(e -> e.getValue().street.equals(street) && Integer.valueOf(e.getValue().house).equals(house))
                .forEach(e -> peopleInHouse.add(e.getKey()));
        return peopleInHouse;
    }
}



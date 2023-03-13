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

    public Map<String, Address> book = new HashMap<>();
    public Map<String, List<String>> bookStreet = new HashMap<>();
    public Map<String, List<String>> bookHouse = new HashMap<>();


    public void addAddress(Address address, String surName) {
        book.put(surName, address);

        if (bookStreet.containsKey(address.street)) {
            bookStreet.get(address.street).add(surName);
        }
        else {
            bookStreet.put(address.street, new ArrayList<>());
            bookStreet.get(address.street).add(surName);
        }

        if (bookHouse.containsKey(address.street + address.house)) {
            bookHouse.get(address.street + address.house).add(surName);
        }
        else {
            bookHouse.put(address.street + address.house, new ArrayList<>());
            bookHouse.get(address.street + address.house).add(surName);
        }
    }

    public void removePerson(String surName) {
        Address adr = getAddress(surName);
        bookStreet.get(adr.street).remove(surName);
        bookHouse.get(adr.street + adr.house).remove(surName);
        book.remove(surName);
    }

    public Address getAddress(String surName) {
        return book.get(surName);
    }

    public void changeAddress(Address address, String surName) {
        removePerson(surName);
        addAddress(address, surName);
    }

    public List<String> getPeopleOnStreet(String street) {
        return bookStreet.get(street);
    }

    public List<String> getPeopleInHouse(String street, Integer house) {
        return bookHouse.get(street + house);
    }
}



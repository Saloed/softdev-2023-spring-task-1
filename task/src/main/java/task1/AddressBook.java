package task1;

import java.util.ArrayList;
import java.util.HashMap;
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

    public ArrayList<String> getPeopleOnStreet(String street) {
        ArrayList<String> peopleOnStreet = new ArrayList<String>();
        for (Map.Entry<String, Address> element: book.entrySet()) {
            if (element.getValue().street.equals(street)) {
                peopleOnStreet.add(element.getKey());
            }
        }
        return peopleOnStreet;
    }

    public ArrayList<String> getPeopleInHouse(String street, int house) {
        ArrayList<String> peopleInHouse = new ArrayList<String>();
        for (Map.Entry<String, Address> element: book.entrySet()) {
            if (element.getValue().street.equals(street) && Integer.valueOf(element.getValue().house).equals(house)) {
                peopleInHouse.add(element.getKey());
            }
        }
        return peopleInHouse;
    }
}



package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {
    private Map<String, Address> addressBookMap;

    public AddressBook() {
        this.addressBookMap = new HashMap<>();
    }

    public Map<String, Address> getAddressBookMap() {
        return addressBookMap;
    }

    public boolean addHumanAddressPairToAddressBook(String human, Address address) {
        if (addressBookMap.containsKey(human)) {
            return false;
        }
        addressBookMap.put(human, address);
        return true;
    }

    public boolean deleteHuman(String human) {
        if (!addressBookMap.containsKey(human)) {
            return false;
        }
        addressBookMap.remove(human);
        return true;
    }

    public boolean updateAddress(Address address, String human) {
        if (!addressBookMap.containsKey(human)) {
            return false;
        }
        addressBookMap.replace(human, address);
        return true;
    }

    public Address getAddressByHuman(String human) {
        return addressBookMap.getOrDefault(human, null);
    }

    public List<String> getListHumansByStreet(String street) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Address> pair : addressBookMap.entrySet()) {
            if (pair.getValue().getStreet().equals(street)) {
                list.add(pair.getKey());
            }
        }
        return list;
    }

    public List<String> getListHumansByHome(int home) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Address> pair : addressBookMap.entrySet()) {
            if (pair.getValue().getHome() == home) {
                list.add(pair.getKey());
            }
        }
        return list;
    }
}

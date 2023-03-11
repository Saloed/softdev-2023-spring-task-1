import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Address {
    String street;
    int house;
    int flat;

    public Address(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }
}

public class AddressBook {
    Map<String, Address> book = new HashMap<>();
    Map<String, List<String>> streetBook = new HashMap<>();
    Map<String, Map<Integer, List<String>>> houseBook = new HashMap<>();
    public void add(String name, Address adress) {
        book.put(name, adress);
        if (streetBook.containsKey(adress.street)) streetBook.get(adress.street).add(name);
        else {
            List<String> nameList = new ArrayList<>();
            nameList.add(name);
            streetBook.put(adress.street, nameList);
        }

        if (houseBook.containsKey(adress.street)) {
            if (houseBook.get(adress.street).containsKey(adress.house))
                houseBook.get(adress.street).get(adress.house).add(name);
            else {
                List<String> list = new ArrayList<>();
                list.add(name);
                houseBook.get(adress.street).put(adress.house, list);
            }
        } else {
            Map<Integer, List<String>> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            list.add(name);
            map.put(adress.house, list);
            houseBook.put(adress.street, map);
        }
    }

    public void remove(String name) {
        String street = book.get(name).street;
        int houseNum = book.get(name).house;
        Map<Integer, List<String>> houseMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add(name);
        houseMap.put(houseNum, list);
        book.remove(name);
        streetBook.remove(street, name);
        houseBook.remove(street, houseMap);
    }

    public void replace(String name, Address adress) {
        String oldAdress = book.get(name).street;
        int oldHouse = book.get(name).house;
        book.replace(name, adress);
        List<String> list = new ArrayList<>();
        list.add(name);
        Map<Integer, List<String>> houseMap = new HashMap<>();
        houseMap.put(adress.house, list);
        if (streetBook.containsKey(adress.street)) {
            streetBook.remove(oldAdress, name);
            streetBook.get(adress.street).add(name);
        } else {
            streetBook.remove(oldAdress, name);
            streetBook.put(adress.street, list);
        }
        if (houseBook.containsKey(adress.street) && !houseBook.get(adress.street).containsKey(adress.house)) {
            houseBook.remove(oldHouse, name);
            houseBook.put(adress.street, houseMap);
        } else if (!houseBook.containsKey(adress.street)) {
            houseBook.remove(oldHouse, name);
            houseBook.put(adress.street, houseMap);
        }
    }
    public Address findAdress(String name) {
        return book.get(name);
    }
    public List<String> findStreet(String street) {
        return streetBook.get(street);
    }
    public List<String> findStreetAndHouse(String street, int house) {return houseBook.get(street).get(house);}
}

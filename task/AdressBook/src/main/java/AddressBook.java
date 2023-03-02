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
    static Map<String, Address> book = new HashMap<>();

    public void add(String name, Address adress) {
        book.put(name, adress);
    }

    public void remove(String name) {
        book.remove(name);
    }

    public void replace(String name, Address adress) {
        book.replace(name, adress);
    }

    public Address findAdress(String name) {
        return book.get(name);
    }

    public List<String> findStreet(String street) {
        List<String> res = new ArrayList<>();
        for (HashMap.Entry<String, Address> entry : AddressBook.book.entrySet()) {
            if (entry.getValue().street.equals(street)) res.add(entry.getKey());
        }
        return res;
    }
    public List<String> findStreetAndHouse(String street, int house) {
        List<String> res = new ArrayList<>();
        for (HashMap.Entry<String, Address> entry : AddressBook.book.entrySet()) {
            if (entry.getValue().street.equals(street) && entry.getValue().house==house) res.add(entry.getKey());
        }
        return res;
    }
}

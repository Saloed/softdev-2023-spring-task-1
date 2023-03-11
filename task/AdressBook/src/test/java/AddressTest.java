import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    @Test
    public void testAdressBook() {
        AddressBook adressBook = new AddressBook();
        Address adr = new Address("Первая", 20, 30);
        adressBook.add("Кузнецов", adr);
        Address adr2 = new Address("Первая", 120, 130);
        adressBook.add("Сидоров", adr2);
        Address adr1 = new Address("Вторая", 40, 770);
        adressBook.add("Петров", adr1);
        Address adr6 = new Address("remove", 70, 70);
        adressBook.add("RemoveMan",adr6);
        adressBook.remove("RemoveMan");
        Address adr3 = new Address("Вторая", 10, 50);
        adressBook.replace("Кузнецов", adr3);
        Address adr4 = new Address("qwe", 40, 130);
        adressBook.add("zxc", adr4);
        Address adr5 = new Address("qwe", 40, 770);
        adressBook.add("asd", adr5);
        List<String> houseExp = new ArrayList<>();
        houseExp.add("asd");
        houseExp.add("zxc");
        assertEquals(houseExp, adressBook.findStreetAndHouse("qwe", 40));
        assertEquals(adr1, adressBook.findAdress("Петров"));
        Address find1 = new Address("find", 10, 11);
        adressBook.add("New1", find1);
        Address find2 = new Address("find", 11, 11);
        adressBook.add("New2", find2);
        List<String> res = new ArrayList<>();
        res.add("New1");
        res.add("New2");
        adressBook.findStreet("find");
        assertEquals(res, adressBook.findStreet("find"));
    }
}

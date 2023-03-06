package task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressBookTest {
    @Test
    public void testAddressBook() {
        AddressBook aBook = new AddressBook();
        Address first = new Address("Baker", 221, 1);
        Address second = new Address("Baker", 221, 2);
        Address third = new Address("Baker", 16, 32);
        Address fourth = new Address("Bedford", 90, 17);
        Address fifth = new Address("Bleecker", 7, 28);

        aBook.addAddress(first, "Holmes");
        aBook.addAddress(second, "Watson");
        aBook.addAddress(third, "Johnson");
        aBook.addAddress(fourth, "Geller");

        List <String> list = new ArrayList<>();
        list.add("Johnson");
        list.add("Watson");
        list.add("Holmes");
        assertEquals(list, aBook.getPeopleOnStreet("Baker"));

        List<String> list1 = new ArrayList<>();
        list1.add("Watson");
        list1.add("Holmes");
        assertEquals(list1, aBook.getPeopleInHouse("Baker", 221));

        aBook.removePerson("Johnson");
        aBook.changeAddress(fifth, "Watson");
        assertEquals(first, aBook.getAddress("Holmes"));
    }
}

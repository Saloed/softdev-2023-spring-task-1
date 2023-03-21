package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {



    @org.junit.jupiter.api.Test
    void deleteHuman() {
        AddressBook addressBook = new AddressBook();
        String human = "Романов";
        String fakeHuman = "Байден";
        Address address = new Address("Ленина", 15, 1);
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human, address));
        assertFalse(addressBook.deleteHuman(fakeHuman));
        assertTrue(addressBook.deleteHuman(human));
    }

    @org.junit.jupiter.api.Test
    void updateAddress() {
        AddressBook addressBook = new AddressBook();
        String human = "Романов";
        String fakeHuman = "Байден";
        Address trueAddress = new Address("Лесная", 132, 324);
        Address fakeAddress = new Address("Мира", 32, 45);
        Address address = new Address("Ленина", 15, 1);
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human, address));
        assertFalse(addressBook.updateAddress(fakeAddress, fakeHuman));
        assertTrue(addressBook.updateAddress(trueAddress, human));
    }
    @org.junit.jupiter.api.Test
    void getAddressByHuman() {
        AddressBook addressBook = new AddressBook();
        String human = "Романов";
        Address address = new Address("Ленина", 15, 1);
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human, address));
        assertNull((BooleanSupplier) addressBook.getAddressByHuman(null));
        assertEquals(address, addressBook.getAddressByHuman(human));
    }

    @org.junit.jupiter.api.Test
    void getListHumansByStreet() {
        AddressBook addressBook = new AddressBook();
        String human1 = "Романов";
        String human2 = "Байден";
        String human3 = "Любятов";
        String human4 = "Абама";
        Address address3 = new Address("Лесная", 132, 324);
        Address address2 = new Address("Мира", 32, 45);
        Address address1 = new Address("Ленина", 15, 1);
        Address address4 = new Address("Лесная", 13, 3);
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human1, address1));
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human2, address2));
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human3, address3));
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human4, address4));
        Address address = new Address("Лесная", 132, 324);
        List<String> expected = List.of("Абама", "Любятов");
        assertEquals(expected, addressBook.getListHumansByStreet("Лесная"));
    }

    @org.junit.jupiter.api.Test
    void getListHumansByHome() {
        AddressBook addressBook = new AddressBook();
        String human1 = "Романов";
        String human2 = "Байден";
        String human3 = "Любятов";
        String human4 = "Абама";
        Address address3 = new Address("Лесная", 132, 324);
        Address address2 = new Address("Мира", 32, 45);
        Address address1 = new Address("Ленина", 15, 1);
        Address address4 = new Address("Лесная", 15, 3);
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human1, address1));
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human2, address2));
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human3, address3));
        assertTrue(addressBook.addHumanAddressPairToAddressBook(human4, address4));
        Address address = new Address("Лесная", 15, 3);
        List<String> expected = List.of("Абама", "Романов");
        assertEquals(expected, addressBook.getListHumansByHome(15));
    }
}
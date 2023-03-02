import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class AddressTest {

    @Test
    public void testAdressBook() {

        AddressBook adressBook=new AddressBook();
        Address adr=new Address("Первая",20,30);
        adressBook.add("Кузнецов", adr);
        Address adr2=new Address("Первая",120,130);
        adressBook.add("Сидоров", adr2);
        Address adr1=new Address("Вторая",40,770);
        adressBook.add("Петров", adr1);

        Address adr3=new Address("Вторая",10,50);
        adressBook.replace("Кузнецов",adr3);


        Address adr4=new Address("qwe",40,130);
        adressBook.add("zxc", adr4);
        Address adr5=new Address("qwe",40,770);
        adressBook.add("asd", adr5);
        List<String> houseExp=new ArrayList<>();
        houseExp.add("asd");
        houseExp.add("zxc");
        assertEquals(houseExp, adressBook.findStreetAndHouse("qwe",40));

        assertEquals(adr1, adressBook.findAdress("Петров"));

        adressBook.findStreet("Вторая");
        List<String> res=new ArrayList<>();
        res.add("Кузнецов");
        res.add("Петров");
        assertEquals(res,adressBook.findStreet("Вторая"));

    }
}

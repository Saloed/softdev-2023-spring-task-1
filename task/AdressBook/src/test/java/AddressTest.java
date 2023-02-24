import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class AddressTest {

    @Test
    public void testAdressBook() {

        AddressBook adressBook=new AddressBook();
        adress adr=new adress("Первая",20,30);
        adressBook.add("Кузнецов", adr);
        adress adr2=new adress("Первая",120,130);
        adressBook.add("Сидоров", adr2);
        adress adr1=new adress("Вторая",40,770);
        adressBook.add("Петров", adr1);

        adress adr3=new adress("Вторая",10,50);
        adressBook.replace("Кузнецов",adr3);


        assertEquals(adr1, adressBook.findAdress("Петров"));
        adressBook.findStreet("Вторая");
        List<String> res=new ArrayList<>();
        res.add("Кузнецов");
        res.add("Петров");
        assertEquals(res,adressBook.findStreet("Вторая"));

        adressBook.print();
    }
}

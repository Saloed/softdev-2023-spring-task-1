import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class adress {
    String street;
    int house;
    int flat;

    public adress(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

}

public class AddressBook {
    static HashMap<String, adress> book = new HashMap();

    public void add(String name, adress adress) {
        book.put(name, adress);
    }
    public void remove(String name){
        book.remove(name);
    }
    public void replace(String name,adress adress){
        book.replace(name, adress);
    }
    public adress findAdress(String name){
        System.out.println(book.get(name).street+" "+book.get(name).house+" "+book.get(name).flat);
        return book.get(name);
    }
    public List<String> findStreet(String street){
        List<String> res=new ArrayList<>();
        for (HashMap.Entry<String, adress> entry : AddressBook.book.entrySet()){
            if (entry.getValue().street==street) res.add(entry.getKey());
        }
        return res;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<String, adress> entry : AddressBook.book.entrySet()) {
            sb.append(entry.getKey());
            sb.append(' ');
            sb.append(entry.getValue().street);
            sb.append(' ');

            sb.append(entry.getValue().house);
            sb.append(' ');

            sb.append(entry.getValue().flat);
            sb.append(' ');

            sb.append('&');
        }
        sb.deleteCharAt(sb.length() - 1);
        String result = sb.toString();
        System.out.println(result);
    }
}

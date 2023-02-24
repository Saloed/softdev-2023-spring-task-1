import java.util.HashMap;

public class Main {

public static void main(String[]args){
    AddressBook adressBook=new AddressBook();
//    adress adr=new adress();
//    adress adr1=new adress();
//    adress adr2=new adress();
//    adress adr3=new adress();
//    adress adr4=new adress();
//
//    adr.street="Первая";
//    adr.house=10;
//    adr.flat=15;
//    System.out.println("Сейчас добавился 1");
//    adressBook.add("Иванов",adr);
//    adressBook.print();
//
//    adr2.street="Вторая";
//    adr2.house=100;
//    adr2.flat=150;
//    System.out.println("Сейчас +2");
//    adressBook.add("Петров",adr2);
//    adressBook.print();
//
//    adr3.street="Первая";
//    adr3.house=200;
//    adr3.flat=30;
//    System.out.println("Сейчас +3");
//    adressBook.add("Сидоров",adr);
//    adressBook.print();
//
//    adr1.street="Первая";
//    adr1.house=20;
//    adr1.flat=10;
//    System.out.println("Сейчас заменили адресс Иванова");
//    adressBook.replace("Иванов",adr1);
//    adressBook.print();
//
//    System.out.println("Сейчас нашли адресс Петрова");
//    adressBook.findAdress("Петров");
//
//    System.out.println("Сейчас нашли людей на улице первая");
    adress adr=new adress("Первая",20,30);
    adressBook.add("Кузнецов", adr);
    adress adr2=new adress("Первая",120,130);
    adressBook.add("Сидоров", adr2);
    System.out.println(adressBook.findStreet("Первая"));
//
//    adressBook.print();
}

}

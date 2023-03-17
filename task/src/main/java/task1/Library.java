package task1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> library = new ArrayList<>();
    public Library() {}

    //"Добавление книги в библиотеку".
    //Если книги в библиотеке нет - выведется true (успешное добавление), если есть - false.
    public Boolean addBook(Book book) {
        String n = book.name;
        String a = book.author;
        for (Book libraryBook : library) {
            if (libraryBook.name.equals(n) && libraryBook.author.equals(a)) return false;
        }
        library.add(book);
        return true;
    }
    //"Удаление книги из библиотеки".
    //Если книга есть в библиотеке - выведется true (успешное удаление), если нет - false.
    public Boolean removeBook(Book book) {
        String n = book.name;
        String a = book.author;
        for (Book libraryBook : library) {
            if (libraryBook.name.equals(n) && libraryBook.author.equals(a)) {
                library.remove(libraryBook);
                return true;
            }
        }
        return false;
    }

    //"Поиск книг по автору".
    //В конце выведется список из книг этого автора, если книг нет - выведется пустой список.
    public List<Book> searchByAuthor(String searchAuthor) {
        List<Book> list = new ArrayList<>();
        for (Book libraryBook : library) {
            if (libraryBook.author.equals(searchAuthor)) {
                list.add(libraryBook);
            }
        }
        return list;
    }

    //"Поиск книг по жанру".
    //В конце выведется список из книг этого жанра, если книг нет - выведется пустой список.
    public List<Book> searchByGenre(String searchGenre) {
        List<Book> list = new ArrayList<>();
        for (Book libraryBook : library) {
            if (searchGenre.equals(libraryBook.genre)) {
                list.add(libraryBook);
            }
        }
        return list;
    }

    //"Поиск книг по автору и жанру".
    //В конце выведется список из книг этих автора и жанра, если книг нет - выведется пустой список.
    public List<Book> searchByAuthorAndGenre(String searchAuthor, String searchGenre) {
        List<Book> list = new ArrayList<>();
        for (Book libraryBook : library) {
            if (searchAuthor.equals(libraryBook.author)) {
                list.add(libraryBook);
            }
        }
        list.removeIf(libraryBook -> !searchGenre.equals(libraryBook.genre));
        return list;
    }

    //"Поставить книгу на другую полку".
    //В конце выведется true - если номер полки изменен; false - если такой книги нет или она уже стоит на нужной полке.
    public Boolean shelfChange(Book book, int newShelf) {
        String n = book.name;
        String a = book.author;
        for (Book libraryBook : library) {
            if (libraryBook.name.equals(n) && libraryBook.author.equals(a)) {
                if (libraryBook.shelf == newShelf) return false;
                libraryBook.shelf = newShelf;
                return true;
            }
        }
        return false;
    }
}

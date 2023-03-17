package task1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    public void testAddBook() {
        var library = new Library();
        assertTrue(library.addBook(new Book("The Shining", "Stephen King", "horror", 1)));
        assertTrue(library.addBook(new Book("Doctor Sleep", "Stephen King", "horror", 1)));
        assertFalse(library.addBook(new Book("The Shining", "Stephen King", "horror", 3)));
        assertTrue(library.addBook(new Book("11/22/63", "Stephen King", "sci-fi", 4)));
    }
    @Test
    public void testRemoveBook() {
        var library = new Library();
        assertTrue(library.addBook(new Book("The Shining", "Stephen King", "horror", 1)));
        assertTrue(library.addBook(new Book("Doctor Sleep", "Stephen King", "horror", 2)));
        assertTrue(library.addBook(new Book("11/22/63", "Stephen King", "sci-fi", 4)));
        assertTrue(library.removeBook(new Book("Doctor Sleep", "Stephen King", "horror", 3)));
        assertFalse(library.removeBook(new Book("Mr. Mercedes", "Stephen King", "detective", 3)));
    }
    @Test
    public void testSearchByAuthor() {
            var library = new Library();
            Book book1 = new Book("The Shining", "Stephen King", "horror", 7);
            Book book2 = new Book("Doctor Sleep", "Stephen King", "horror", 10);
            Book book3 = new Book("Mr. Mercedes", "Stephen King", "detective", 1);
            Book book4 = new Book("11/22/63", "Stephen King", "sci-fi", 4);
            Book book5 = new Book("Fight Club", "Chuck Palahniuk", "crime drama", 5);
            Book book6 = new Book("Perfume. The story of a murderer", "Patrick Suskind", "drama", 4);
        assertTrue(library.addBook(book1));
        assertTrue(library.addBook(book2));
        assertTrue(library.addBook(book3));
        assertTrue(library.addBook(book4));
        assertTrue(library.addBook(book5));
        assertTrue(library.addBook(book6));
            List<Book> test1 = new ArrayList<>();
            test1.add(book1);
            test1.add(book2);
            test1.add(book3);
            test1.add(book4);
        assertEquals(test1, library.searchByAuthor("Stephen King"));
            List<Book> test2 = new ArrayList<>();
            test2.add(book5);
        assertEquals(test2, library.searchByAuthor("Chuck Palahniuk"));
        assertEquals(new ArrayList<>(), library.searchByAuthor("Agatha Christie"));
    }
    @Test
    public void testSearchByGenre() {
            var library = new Library();
            Book book1 = new Book("The Shining", "Stephen King", "horror", 7);
            Book book2 = new Book("Doctor Sleep", "Stephen King", "horror", 10);
            Book book3 = new Book("Mr. Mercedes", "Stephen King", "detective", 1);
            Book book4 = new Book("11/22/63", "Stephen King", "sci-fi", 4);
            Book book5 = new Book("Fight Club", "Chuck Palahniuk", "crime drama", 5);
            Book book6 = new Book("Perfume. The story of a murderer", "Patrick Suskind", "drama", 4);
        assertTrue(library.addBook(book1));
        assertTrue(library.addBook(book2));
        assertTrue(library.addBook(book3));
        assertTrue(library.addBook(book4));
        assertTrue(library.addBook(book5));
        assertTrue(library.addBook(book6));
            List<Book> test1 = new ArrayList<>();
            test1.add(book1);
            test1.add(book2);
        assertEquals(test1, library.searchByGenre("horror"));
            List<Book> test2 = new ArrayList<>();
            test2.add(book4);
        assertEquals(test2, library.searchByGenre("sci-fi"));
        assertEquals(new ArrayList<>(), library.searchByGenre("comedy"));
    }
    @Test
    public void testSearchByAuthorAndGenre() {
            var library = new Library();
            Book book1 = new Book("The Shining", "Stephen King", "horror", 7);
            Book book2 = new Book("Doctor Sleep", "Stephen King", "horror", 10);
            Book book3 = new Book("Mr. Mercedes", "Stephen King", "detective", 1);
            Book book4 = new Book("11/22/63", "Stephen King", "sci-fi", 4);
            Book book5 = new Book("Fight Club", "Chuck Palahniuk", "crime drama", 5);
            Book book6 = new Book("Perfume. The story of a murderer", "Patrick Suskind", "drama", 4);
        assertTrue(library.addBook(book1));
        assertTrue(library.addBook(book2));
        assertTrue(library.addBook(book3));
        assertTrue(library.addBook(book4));
        assertTrue(library.addBook(book5));
        assertTrue(library.addBook(book6));
            List<Book> test1 = new ArrayList<>();
            test1.add(book1);
            test1.add(book2);
        assertEquals(test1, library.searchByAuthorAndGenre("Stephen King", "horror"));
            List<Book> test2 = new ArrayList<>();
            test2.add(book6);
        assertEquals(test2, library.searchByAuthorAndGenre("Patrick Suskind", "drama"));
        assertEquals(new ArrayList<>(), library.searchByAuthorAndGenre("Stephen King", "fantasy"));
        assertEquals(new ArrayList<>(), library.searchByAuthorAndGenre("Arthur Conan Doyle", "detective"));
        assertEquals(new ArrayList<>(), library.searchByAuthorAndGenre("Edgar Allan Poe", "mystic"));
    }
    @Test
    public void testShelfChange() {
        var library = new Library();
        assertTrue(library.addBook(new Book("The Shining", "Stephen King", "horror", 1)));
        assertTrue(library.addBook(new Book("Doctor Sleep", "Stephen King", "horror", 7)));
        assertTrue(library.addBook(new Book("11/22/63", "Stephen King", "sci-fi", 4)));
        assertTrue(library.shelfChange(new Book("Doctor Sleep", "Stephen King", "horror", 7), 2));
        assertFalse(library.shelfChange(new Book("Doctor Sleep", "Stephen King", "horror", 2), 2));
        assertFalse(library.shelfChange(new Book("Mr. Mercedes", "Stephen King", "detective", 3), 1));
    }
}

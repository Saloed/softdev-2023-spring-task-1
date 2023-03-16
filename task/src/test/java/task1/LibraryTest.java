package task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task1.Book;
import task1.Library;

import java.util.HashSet;
import java.util.Set;

public class LibraryTest {
    Library lib;

    @Before
    public void extraData() {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("thriller", "A1", "The push", "Ashley Audrain"));
        bookSet.add(new Book("thriller", "B1", "Dear Child", "Romy Hausmann"));
        bookSet.add(new Book("romance", "C1", "Glow", "Raven Kennedy"));
        bookSet.add(new Book("romance", "D1", "Love on the brain", "Ali Hazelwood"));
        lib = new Library(bookSet);
    }

    @Test
    public void addBooksInConstructorAndFindThem() {
        if (!lib.findBooks("thriller").contains(new Book("thriller", "A1", "The push", "Ashley Audrain"))) {
            Assert.fail();
        }
        if (!lib.findBooks("thriller").contains(new Book("thriller", "B1", "Dear Child", "Romy Hausmann"))) {
            Assert.fail();
        }
        Assert.assertTrue(true);
    }

    @Test
    public void addBookAndDeleteIt() {
        lib.deleteBook(new Book("thriller", "A1", "The push", "Ashley Audrain"));
        lib.deleteBook(new Book("romance", "D1", "Love on the brain", "Ali Hazelwood"));
        if (lib.findBooks("thiller").contains(new Book("thriller", "A1", "The push", "Ashley Audrain")))
            Assert.fail();
        if (lib.findBooks("romance").contains(new Book("romance", "D1", "Love on the brain", "Ali Hazelwood")))
            Assert.fail();

        lib.addBook(new Book("romance", "D1", "Love on the brain", "Ali Hazelwood"));
        if (!lib.findBooks("romance").contains(new Book("romance", "D1", "Love on the brain", "Ali Hazelwood")))
            Assert.fail();
        Assert.assertTrue(true);
    }

    @Test
    public void changeShelf() {
        lib.changeShelf(new Book("romance", "D1", "Love on the brain", "Ali Hazelwood"), "E123");
        if (!lib.findBooks("Love on the brain").contains(new Book("romance", "E123", "Love on the brain", "Ali Hazelwood")))
            Assert.fail();
        Assert.assertTrue(true);
    }

    @Test
    public void replaceBook() {
        lib.replaceBook(new Book("romance", "D1", "Love on the brain", "Ali Hazelwood"),
                new Book("thriller", "Any", "The push", "Ashley Audrain"));
        if (!lib.findBooks("The push").contains(new Book("thriller", "D1", "The push", "Ashley Audrain")))
            Assert.fail();
        Assert.assertTrue(true);
    }

}

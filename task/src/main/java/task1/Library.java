package task1;

import java.util.*;

public class Library {
    private Set<Book> books = new HashSet<>();

    public Library(Collection<Book> booksToAdd) {
        books.addAll(booksToAdd);
    }
    public boolean addBook(Book bookToAdd) {
        if (books.contains(bookToAdd)) return false;
        books.add(bookToAdd);
        return true;
    }

    public boolean deleteBook(Book bookToDelete) {
        if (!books.contains(bookToDelete)) return false;
        books.remove(bookToDelete);
        return true;
    }

    public boolean changeShelf(Book bookToChangeShelf, String newShelf) {
        if (!books.contains(bookToChangeShelf)) return false;
        books.remove(bookToChangeShelf);
        Book newBook = bookToChangeShelf.clone();
        newBook.setShelfCode(newShelf);
        books.add(newBook);
        return true;
    }

    public boolean replaceBook(Book oldOne, Book newOne) {
        if (!books.contains(oldOne) || books.contains(newOne)) return false;
        Book newOneClone = newOne.clone();
        newOneClone.setShelfCode(oldOne.getShelfCode());
        books.remove(oldOne);
        books.add(newOneClone);
        return true;
    }

    public Collection<Book> findBooks(String... args) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books)
            go:{
                for (int i = 0; i < args.length; i++) {
                    if (!List.of(book.getGenre(), book.getAuthor(), book.getTitle(), book.getShelfCode()).contains(args[i])) {
                        break go;
                    }
                }
                foundBooks.add(book);
            }
        return foundBooks;
    }

}

package task1;

public class Book implements Cloneable {
    private String author;
    private String genre;
    private String title;
    private String shelfCode;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public void setShelfCode(String shelfCode) {
        this.shelfCode = shelfCode;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getShelfCode() {
        return shelfCode;
    }

    public Book(String genre, String shelfCode, String title, String author) {
        this.genre = genre;
        this.author = author;
        this.shelfCode = shelfCode;
        this.title = title;
    }

    @Override
    public int hashCode() {
        return author.hashCode() + genre.hashCode() + shelfCode.hashCode() + title.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null || other.hashCode() != this.hashCode()) return false;
        if (!(other instanceof Book)) return false;
        return (this.author.equals(((Book) other).author)) &&
                (this.genre.equals(((Book) other).genre)) &&
                (this.shelfCode.equals(((Book) other).shelfCode)) &&
                (this.title.equals(((Book) other).title));
    }

    @Override
    public String toString() {
        return String.format("Title = %s\nAuthor = %s\nGenre = %s\nShelfCode = %s", title, author, genre, shelfCode);
    }

    @Override
    public Book clone() {
        return new Book(genre, shelfCode, title, author);
    }
}

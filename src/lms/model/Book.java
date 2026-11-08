package lms.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title,String author,String isbn,boolean isBorrowed){
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        this.isBorrowed=false;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }
    public boolean isBorrowed(){
        return isBorrowed;
    }
    public void setTitle(String title) {
        if (title==null ||title.isBlank()) {
            throw new IllegalArgumentException("Title can't be blank");
        }
        this.title=title;
    }

    public void setAuthor(String author) {
        if (author==null ||author.isBlank()) {
            throw new IllegalArgumentException("Author can't be blank");
        }
        this.author=author;
    }

    public void setIsbn(String isbn) {
        if (isbn==null ||isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN can't be blank");
        }
        this.isbn=isbn;
    }

    public void setBorrowed(boolean borrowed) {
        this.isBorrowed=borrowed;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', isbn='" + isbn + "', borrowed=" + isBorrowed + "}";
    }
}

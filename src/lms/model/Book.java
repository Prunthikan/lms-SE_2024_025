
package lms.model;

public class Book extends LibraryItem {

    private String author;
//call using super constructor
    public Book(String id,String title,String author) {
        super(id, title);
        setAuthor(author);
    }
//getter
    public String getAuthor() {
        return author;
    }
//setter
    public void setAuthor(String author) {
        if (author ==null ||author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author can't be empty");
        }
        this.author= author;
    }
}

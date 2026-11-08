package lms;
import lms.model.Book;
import lms.model.Member;
import lms.service.Library;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // Adding books
        library.addBook(new Book("Clean Code","Robert C. Martin","978-0132350884",false));

        library.addBook(new Book("Effective Java","Joshan","978-0134685991",false));

        library.addBook(new Book("The Programmer","Thomas","978-0135957059",false));

        // Adding members
        library.addMember(new Member("M001","Kamal"));

        library.addMember(new Member("M002","Vimal"));

        // Display books and members
        library.listBooks();
        library.listMembers();

        // Testing invalid condition
        try {
            Book invalidBook = new Book("","Nobody","000-0000000000",false);

            library.addBook(invalidBook);

        } catch (IllegalArgumentException e) {

            System.out.println("Reject invalid book: " +e.getMessage());
        }
    }
}


package lms;
import lms.model.Book;
import lms.model.DVD;
import lms.model.Student;
import lms.model.Staff;
import lms.service.Library;

public class Main {
    public static void main(String[] args) {

        Library library=new Library();

        // Create object  Books
        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");

        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");

        // Create object DVD
        DVD d1 = new DVD("D001", "Introduction to Inheritance", 120);

        // Add items in Main
        library.addItem(b1);
        library.addItem(b2);
        library.addItem(d1);

        // Create Members in Main
        Student student = new Student("S001", "Prunthikan");
        Staff staff = new Staff("ST001", "Joshan");

        library.addMember(student);
        library.addMember(staff);

        // Display items and members in main
        library.listItems();
        library.listMembers();

        // Calculate late of fees part
        library.printAllLateFees(3);

        // Test streaming part
        System.out.println("\n---------------Streaming Test-----------------");
        library.streamIfPossible(d1);
        library.streamIfPossible(b1);
    }
}

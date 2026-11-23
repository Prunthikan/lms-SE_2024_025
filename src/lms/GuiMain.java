package lms;

import lms.model.Book;
import lms.model.DVD;
import lms.model.Magazine;
import lms.model.Student;
import lms.model.Staff;
import lms.service.Library;
import lms.ui.MainFrame;

import javax.swing.SwingUtilities;

public class GuiMain{
    public static void main(String[] args){
        // Create Library object
        Library library =new Library();

        // Create Books objects
        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");
        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");
        Book b3 = new Book("B005", "Java Basics", "John");
        Book b4 = new Book("B006", "Java Advanced", "David");
        Book b5 = new Book("B007", "Java Programming", "James");

        // Create DVD object
        DVD d1 = new DVD("D001", "Introduction to Inheritance", 120);

        // Create Magazine
        Magazine m1 = new Magazine("M001", "Software_Tension", "Issue 27");


        // Add items to Library
        library.addItem(b1);
        library.addItem(b2);
        library.addItem(d1);
        library.addItem(m1);
        library.addItem(b3);
        library.addItem(b4);
        library.addItem(b5);

        // Creating  Members (Student, Staff)
        Student student = new Student("S001", "Prunthikan");

        Staff staff = new Staff("ST001", "Joshan");

        // Adding  Members to Library
        library.addMember(student);
        library.addMember(staff);

        // Open GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new MainFrame(library).setVisible(true));
    }
}

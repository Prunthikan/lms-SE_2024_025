package lms;
import lms.model.Book;
import lms.model.DVD;
import lms.model.Student;
import lms.model.Staff;
import lms.service.Library;
import lms.model.Magazine;

public class Main{
    public static void main(String[] args){
        // create object for Library

        Library library=new Library();

        // create object  Books
        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");

        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");

        // create object DVD
        DVD d1 = new DVD("D001", "Introduction to Inheritance", 120);
        // create object for magazine
        Magazine m1 = new Magazine("M001", "Software_Tension", "Issue 27");

        // add items in Main
        library.addItem(b1);
        library.addItem(b2);
        library.addItem(d1);
        library.addItem(m1);

        // create Members in Main
        Student student =new Student("S001", "Prunthikan");
        Staff staff =new Staff("ST001", "Joshan");

        library.addMember(student);
        library.addMember(staff);

        // display items and members in main
        library.listItems();
        library.listMembers();

        // lending Items list
        System.out.println("----------------Loans of Pending-----------------------");
        library.lend(b1,student);
        library.lend(b2,staff);
        library.lend(d1,staff);
        library.lend(m1,staff);

        // calculate late of fees part
        library.printAllLateFees(3);

        // test streaming part
        System.out.println("\n---------------Streaming Test-----------------");
        library.streamIfPossible(d1);
        library.streamIfPossible(b1);

       // reservation Part
        System.out.println("---------------------Reservations list ----------------------");
        library.reserveIfPossible(b1,staff);
        library.reserveIfPossible(d1,staff);


        library.printMembersByActivity();//member activity rankings list
    }

}

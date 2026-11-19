package lms;
import lms.model.Book;
import lms.model.DVD;
import lms.model.Student;
import lms.model.Staff;
import lms.service.Library;
import lms.model.Magazine;
import lms.exception.ItemNotAvailableException;
import lms.exception.MemberNotFoundException;

public class Main{
    public static void main(String[] args){
        // create object for Library

        Library library=new Library();

        // create object  Books
        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");

        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");
        Book b3 = new Book("B005", "Java Basics", "John");
        Book b4 = new Book("B006", "Java Advanced", "David");
        Book b5 = new Book("B007", "Java Programming", "James");

        // create object DVD
        DVD d1 = new DVD("D001", "Introduction to Inheritance", 120);
        // create object for magazine
        Magazine m1 = new Magazine("M001", "Software_Tension", "Issue 27");

        // add items in Main
        library.addItem(b1);
        library.addItem(b2);
        library.addItem(d1);
        library.addItem(m1);
        library.addItem(b3);
        library.addItem(b4);
        library.addItem(b5);

        // create Members in Main
        Student student =new Student("S001", "Prunthikan");
        Staff staff =new Staff("ST001", "Joshan");

        library.addMember(student);
        library.addMember(staff);

        // display items and members in main
        library.listItems();
        library.listMembers();


        // lending Items list
        System.out.println("\n----------------Loans of Pending-----------------------");
        try {
            library.lend(b2, staff);
            library.lend(d1, staff);
            library.lend(m1, staff);
        }
        catch (ItemNotAvailableException e) {
            System.out.println("Cannot lend: " + e.getMessage());
        }

        // calculate late of fees part
        library.printAllLateFees(3);

        // test streaming part
        System.out.println("\n---------------Streaming Test-----------------");
        library.streamIfPossible(d1);
        library.streamIfPossible(b1);

       // reservation Part
        System.out.println("\n---------------------Reservations list ----------------------\n");
        library.reserveIfPossible(b1,staff);
        library.reserveIfPossible(d1,staff);


        library.printMembersByActivity();//member activity rankings list
        // 1. Successful borrowing
        System.out.println("\n----- 1.Successful borrowing ------");
        attempt(library,"B001","M001");

        // 2. Already on loan
        System.out.println("\n------ 2.Already on loan (checked exception)---- ---");
        attempt(library,"B001","M002");

        // 3. Unknown member
        System.out.println("\n-------3.Unknown member (unchecked exception)---- ---");
        attempt(library,"D001","M999");

        // 4. Unknown item
        System.out.println("\n------ 4.Unknown item ------");
        attempt(library,"X404","M001");

        // 5. Returning something not on loan
        System.out.println("\n-------5.Returning something not on loan-------");

        try {
            library.returnItem("D001");
        }
        catch (ItemNotAvailableException e){
            System.out.println("Cannot return: " +e.getMessage());
        }

        // 6. Bad data
        System.out.println("\n----------6.Bad data (IllegalArgumentException) ----------");

        try {
            new Book("B002", " ", "Someone");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid book: " + e.getMessage());
        }

        // 7. Student borrowing limit of 3
        System.out.println("\n--------- 7.Student borrowing limit ----------");

        attempt(library, "B005", "M001");
        attempt(library, "B006", "M001");
        attempt(library, "B007", "M001");

        // 8. Return frees a slot
        System.out.println("\n--------- 8. Return frees a slot ---------");

        try {
            library.returnItem("B001");
        }
        catch (ItemNotAvailableException e) {
            System.out.println("Cannot return: " + e.getMessage());
        }

        attempt(library,"B004","M001");
    }

    public static void attempt(Library library, String itemId, String memberId) {
        try {
            library.borrowItem(itemId, memberId);
        }
        catch (ItemNotAvailableException e){
            System.out.println("Can't borrow: "+e.getMessage());
        }
        catch (MemberNotFoundException e) {
            System.out.println("Unknown member: "+e.getMemberId());
        }
        finally {
            System.out.println("(attempt finished: item " + itemId + ", member " + memberId + ")");
        }
    }


}

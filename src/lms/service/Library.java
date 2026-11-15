package lms.service;

import lms.model.Book;
import lms.model.DVD;
import lms.model.LibraryItem;
import lms.model.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    // Method Overloading
    public void addItem(LibraryItem item){
        items.add(item);
        System.out.println("Added via addItem(LibraryItem): "+item.getTitle());
    }

    public void addItem(Book book){
        items.add(book);
        System.out.println("Added via addItem(Book): " +book.getTitle());
    }

    public void addItem(DVD dvd){
        items.add(dvd);
        System.out.println("Added via addItem(DVD): " +dvd.getTitle());
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void listItems() {
        System.out.println("\n--------------Library Items ----------------");

        for (LibraryItem item:items) {
            System.out.println(item);
        }
    }

    public void listMembers() {
        System.out.println("\n--------------Library Members---------------");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    // Polymorphism
    public void printAllLateFees(int daysLate) {
        System.out.println("\n-------- Late fees if " + daysLate + " day(s) late -----------");

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateLateFee(daysLate));
        }
    }

    // instanceof
    public void streamIfPossible(LibraryItem item) {
        if (item instanceof DVD dvd) {
            System.out.println("Streaming \"" + dvd.getTitle() + "\" (" + dvd.getDurationMinutes() + " min)I think ");
        } else {
            System.out.println(item.getTitle() + " can't be streamed___it isn't a DVD.");
        }
    }
}

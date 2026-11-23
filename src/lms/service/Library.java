package lms.service;

import lms.model.Book;
import lms.model.DVD;
import lms.model.LibraryItem;
import lms.model.Member;
import lms.model.Loanable;
import lms.model.Reservable;
import lms.exception.ItemNotAvailableException;
import lms.exception.MemberNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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

    public void listItems(){
        System.out.println("\n--------------Library Items ----------------");

        for (LibraryItem item:items){
            System.out.println(item);
        }
    }

    public void listMembers(){
        System.out.println("\n--------------Library Members---------------");
        for (Member member : members){
            System.out.println(member);
        }
    }

    // Polymorphism
    public void printAllLateFees(int daysLate){
        System.out.println("\n-------- Late fees if " + daysLate + " day(s) late -----------");

        for (LibraryItem item :items){
            System.out.println(item.getTitle() + ": " +item.calculateLateFee(daysLate));
        }
    }

    // instanceof
    public void streamIfPossible(LibraryItem item) {
        if (item instanceof DVD dvd) {
            System.out.println("Streaming \"" + dvd.getTitle() + "\" (" + dvd.getDurationMinutes() + " min)I think ");
        }
        else {
            System.out.println(item.getTitle() + " can't be streamed___it isn't a DVD.");
        }
    }

    public void lend(Loanable thing, Member member) throws ItemNotAvailableException{
        thing.loan(member);
    }
    public void reserveIfPossible(LibraryItem item, Member member){

        if (item instanceof Reservable r){
            r.reserve(member);
        }
        else{
            System.out.println(item.getTitle()+" cannot be reserved.");
        }
    }
    public void printMembersByActivity(){

        List<Member>sortedMembers = new ArrayList<>(members);
        Collections.sort(sortedMembers);
        System.out.println("--------------- Members ranked by activity ---------------");

        for (Member member:sortedMembers){
            System.out.println(member.getName()+"("+member.getBorrowedCount()+" is  borrowed)");
        }
    }
    public Member findMember(String memberId){
        for (Member member:members){
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        throw new MemberNotFoundException(memberId);
    }

    public LibraryItem findItem(String itemId) throws ItemNotAvailableException{
        for (LibraryItem item:items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }

        throw new ItemNotAvailableException("No item with id '"+itemId + "'");
    }
    public void borrowItem(String itemId,String memberId) throws ItemNotAvailableException{
        LibraryItem item = findItem(itemId);
        Member member = findMember(memberId);
        item.loan(member);
    }

    public void returnItem(String itemId) throws ItemNotAvailableException{
        LibraryItem item = findItem(itemId);
        item.returnItem();
    }
    public List<LibraryItem> getItems(){
        return items;
    }
}

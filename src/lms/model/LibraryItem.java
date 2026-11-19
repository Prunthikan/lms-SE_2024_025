package lms.model;
import lms.exception.ItemNotAvailableException;

public abstract class LibraryItem implements Loanable{
// attributes
    private String id;
    private String title;
    private boolean isBorrowed;
    private Member borrower;
// constructor
    public LibraryItem(String id, String title){
        setId(id);
        setTitle(title);
        this.isBorrowed= false;
        this.borrower = null;
    }
//getter
    public String getId() {
        return id;
    }
//setter
    public void setId(String id){
        if (id ==null ||id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID can't be empty");
        }
        this.id= id;
    }
//getter
    public String getTitle(){
        return title;
    }
//setter
    public void setTitle(String title) {
        if (title ==null ||title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title can't be empty");
        }
        this.title=title;
    }
//getter
    public boolean isBorrowed(){
        return isBorrowed;
    }
//setter
    public void setBorrowed(boolean borrowed){
        isBorrowed=borrowed;
    }

    public abstract double calculateLateFee(int daysLate);

    @Override
    public void loan(Member member)  throws ItemNotAvailableException {
        if(isBorrowed){
            throw new ItemNotAvailableException(title +" is already on loan");
        }
        if(member.getBorrowedCount()>= member.getMaxBorrowLimit()){
            throw new ItemNotAvailableException(member.getName()+" is reached the limit of "+member.getMaxBorrowLimit()+" items");
        }
        setBorrowed(true);
        borrower = member;
        member.incrementBorrowedCount();
        System.out.println(getTitle()+" is loaned to "+member.getName());
    }

    @Override
    public void returnItem() throws ItemNotAvailableException{
        if (!isBorrowed){
            throw new ItemNotAvailableException(title+" is not on loan.");
        }
        setBorrowed(false);
        if (borrower!= null){
            borrower.decrementBorrowedCount();
            borrower=null;
        }
        System.out.println(getTitle()+" is returned");
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title + "', borrowed=" + isBorrowed + "}";
    }
}


package lms.model;

public abstract class LibraryItem implements Loanable {
// attributes
    private String id;
    private String title;
    private boolean isBorrowed;
// constructor
    public LibraryItem(String id, String title) {
        setId(id);
        setTitle(title);
        this.isBorrowed= false;
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
    public void loan(Member member) {
        if(isBorrowed){
            System.out.println(getTitle()+ " is already in loaned ");
            return;
        }
        if(member.getBorrowedCount()>= member.getMaxBorrowLimit()){
            System.out.println(member.getName()+" is reached the borrow maximum limit");
            return;
        }
        setBorrowed(true);
        member.incrementBorrowedCount();
        System.out.println(getTitle()+ " is loaned to " + member.getName());
    }

    @Override
    public void returnItem() {
        if (!isBorrowed) {
            System.out.println(getTitle()+ " is not currently on loaning");
            return;
        }
        setBorrowed(false);
        System.out.println(getTitle()+" is returned");
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title + "', borrowed=" + isBorrowed + "}";
    }
}



package lms.model;

public class Book extends LibraryItem implements Reservable{

    private String author;
    private Member reservedBy;
//call using super constructor
    public Book(String id,String title,String author){
        super(id, title);
        setAuthor(author);
        this.reservedBy = null;
    }
//getter
    public String getAuthor() {
        return author;
    }
//setter
    public void setAuthor(String author){
        if (author ==null ||author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author can't be empty");
        }
        this.author= author;
    }
    @Override
    public double calculateLateFee(int daysLate){
        return daysLate * 10;
    }
    @Override
    public void reserve(Member member){
        if (isReserved()) {
            System.out.println(getTitle()+ "is already reserved.");
            return;
        }
        reservedBy = member;
        System.out.println(getTitle()+ " is reserved for " +member.getName());
    }

    @Override
    public void cancelReservation(){
        if (reservedBy != null){
            reservedBy = null;
            System.out.println(getTitle()+ " reservation is cancelled.");
        }
    }
    @Override
    public boolean isReserved(){
        return reservedBy!=null;
    }
}

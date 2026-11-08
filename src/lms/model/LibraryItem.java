package lms.model;

public class LibraryItem {
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

    public double calculateLateFee(int daysLate){
        return daysLate * 10.0;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title + "', borrowed=" + isBorrowed + "}";
    }
}


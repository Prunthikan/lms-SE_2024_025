package lms.model;

public class Member{

    private String memberId;
    private String name;
    private int borrowedCount;
    private int maxBorrowLimit;

    public Member(String memberId,String name,int maxBorrowLimit){
        setMemberId(memberId);
        setName(name);
        this.borrowedCount = 0;
        setMaxBorrowLimit(maxBorrowLimit);
    }

    public String getMemberId(){
        return memberId;
    }

    public void setMemberId(String memberId){
        if (memberId ==null||memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID can't be empty");
        }
        this.memberId=memberId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        if (name ==null ||name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }

    public int getBorrowedCount(){
        return borrowedCount;
    }

    public void incrementBorrowedCount(){
        borrowedCount++;
    }

    public int getMaxBorrowLimit(){
        return maxBorrowLimit;
    }

    public void setMaxBorrowLimit(int maxBorrowLimit){
        if (maxBorrowLimit <= 0) {
            throw new IllegalArgumentException("Borrow limit must greater than 0");
        }
        this.maxBorrowLimit = maxBorrowLimit;
    }

    @Override
    public String toString() {
        return "Member{memberId='" + memberId + "', name='" + name + "', borrowedCount=" + borrowedCount + ", maxBorrowLimit=" + maxBorrowLimit + "}";
    }
}

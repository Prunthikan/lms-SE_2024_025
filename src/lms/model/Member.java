package lms.model;

public class Member {
    private String memberId;
    private String name;
    private int borrowedCount;

    public Member(String memberId, String name) {
        setMemberId(memberId);
        setName(name);
        this.borrowedCount = 0;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void setMemberId(String memberId) {
        if (memberId ==null|| memberId.isBlank()) {
            throw new IllegalArgumentException("Member ID can't be blank");
        }
        this.memberId=memberId;
    }

    public void setName(String name) {
        if (name==null||name.isBlank()) {
            throw new IllegalArgumentException("Name can't be blank");
        }
        this.name=name;
    }

    public void setBorrowedCount(int Count) {
        if (Count < 0) {
            throw new IllegalArgumentException("Borrowed count can't be negative");
        }
        this.borrowedCount = Count;
    }

    public void incrementBorrowedCount() {
        setBorrowedCount(this.borrowedCount + 1);
    }

    @Override
    public String toString() {
        return "Member{id='" + memberId + "', name='" + name + "', borrowedCount=" + borrowedCount + "}";
    }
}


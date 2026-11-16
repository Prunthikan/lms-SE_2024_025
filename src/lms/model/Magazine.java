package lms.model;

public class Magazine extends LibraryItem{
    private String issueNumber;

    public Magazine(String id,String title,String issueNumber){
        super(id,title);
        setIssueNumber(issueNumber);
    }

    public String getIssueNumber(){
        return issueNumber;
    }
    public void setIssueNumber(String issueNumber){
        if (issueNumber == null || issueNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Issue_number can't be empty");
        }
        this.issueNumber = issueNumber;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate *5.0;
    }
}

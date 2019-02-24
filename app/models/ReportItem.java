package models;

public class ReportItem {

    private String isbn;
    private String itemTitle;
    private double overdue;
    private Reader currentReader;


    public ReportItem(String isbn, String itemTitle, double overdue, Reader currentReader) {
        this.isbn = isbn;
        this.itemTitle = itemTitle;
        this.overdue = overdue;
        this.currentReader = currentReader;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public double getOverdue() {
        return overdue;
    }

    public void setOverdue(double overdue) {
        this.overdue = overdue;
    }

    public Reader getCurrentReader() {
        return currentReader;
    }

    public void setCurrentReader(Reader currentReader) {
        this.currentReader = currentReader;
    }

}

package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class LibraryItem extends Model {

    @Id
    private String isbn;
    private String title;
    private String sector;
    private Date publicationDate;
    private String borrowedDateTime;

    @ManyToOne(optional = true)
    private Reader currentReader;
    private String status;

    public LibraryItem() {

    }

    public LibraryItem(String isbn, String title, String sector, Date publicationDate, String status) {
        this.isbn = isbn;
        this.title = title;
        this.sector = sector;
        this.publicationDate = publicationDate;
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getBorrowedDateTime() {
        return borrowedDateTime;
    }

    public void setBorrowedDateTime(String borrowedDateTime) {
        this.borrowedDateTime = borrowedDateTime;
    }

    public Reader getCurrentReader() {
        return currentReader;
    }

    public void setCurrentReader(Reader currentReader) {
        this.currentReader = currentReader;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", sector='" + sector + '\'' +
                ", publicationDate=" + publicationDate +
                ", borrowedDateTime=" + borrowedDateTime +
                ", currentReader=" + currentReader +
                ", status='" + status + '\'' +
                '}';
    }
}

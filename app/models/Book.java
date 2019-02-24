package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Book extends LibraryItem {

    private String publisher;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE)
    private List<Author> authors;
    private int numOfPages;

    public Book() {

    }

    public Book(String isbn, String title, String sector, Date publicationDate, String status, Date availableDate,
                String publisher, List<Author> authors, int numOfPages) {
        super(isbn, title, sector, publicationDate, status/*, availableDate*/);
        this.publisher = publisher;
        this.authors = authors;
        this.numOfPages = numOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    @Override
    public String toString() {
        return super.toString()+"Book{" +
                "publisher='" + publisher + '\'' +
                ", authors=" + authors +
                ", numOfPages=" + numOfPages +
                '}';
    }
}

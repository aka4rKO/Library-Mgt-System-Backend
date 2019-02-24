package models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Author extends Person {

    @Id
    private int authorId;

    @ManyToMany
    private List<Book> books;

    public Author() {

    }

    public Author(String name) {
        super(name);
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return super.toString()+"Author{" +
                "authorId=" + authorId +
                '}';
    }
}

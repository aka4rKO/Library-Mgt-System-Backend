package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Actor extends Person {

    @Id
    private int actorId;

    @ManyToMany
    private List<Dvd> dvds;

    public Actor() {

    }

    public Actor(String name) {
        super(name);
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Override
    public String toString() {
        return super.toString()+"Actor{" +
                "actorId=" + actorId +
                '}';
    }
}

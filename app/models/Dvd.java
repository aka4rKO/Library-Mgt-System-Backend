package models;

import io.ebean.annotation.DbArray;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Dvd extends LibraryItem {

    @DbArray
    private List<String> languages;

    @DbArray
    private List<String> subtitles;
    private String producer;

    @ManyToMany(mappedBy = "dvds", cascade = CascadeType.REMOVE)
    private List<Actor> actors;

    public Dvd() {

    }

    public Dvd(String isbn, String title, String sector, Date publicationDate, String status, Date availableDate,
               List<String> languages, List<String> subtitles, String producer, List<Actor> actors) {
        super(isbn, title, sector, publicationDate, status);
        this.languages = languages;
        this.subtitles = subtitles;
        this.producer = producer;
        this.actors = actors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(List<String> subtitles) {
        this.subtitles = subtitles;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return super.toString()+"Dvd{" +
                "languages=" + languages +
                ", subtitles=" + subtitles +
                ", producer='" + producer + '\'' +
                ", actors=" + actors +
                '}';
    }
}

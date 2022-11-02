package io.shazzboard.shazamservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String artist;
    private String duration;
    private String coverArt;

    public Song() {

    }

    public Song(String name, String artist, String duration, String coverArt) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.coverArt = coverArt;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getDuration(){
        return duration;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getCoverArt() { return coverArt; }

    public void setCoverArt(String coverArt) {this.coverArt = coverArt; }
}

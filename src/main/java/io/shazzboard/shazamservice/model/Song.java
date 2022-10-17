package io.shazzboard.shazamservice.model;

public class Song {
    private Long id;
    private String name;
    private String artist;
    private String duration;

    public Song() {

    }

    public Song(String name, String artist, String duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
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

    public void setName(String artist){
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
}

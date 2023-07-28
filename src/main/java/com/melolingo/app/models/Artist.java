package com.melolingo.app.models;
import java.util.List;

public class Artist {
    private String id;
    private String name;
    private List<Album> albums;
    public Artist() {
    }
    public Artist(String id, String name, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public List<Album> getAlbums() {
        return albums;
    }
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
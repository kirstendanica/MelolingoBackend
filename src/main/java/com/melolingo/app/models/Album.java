package com.melolingo.app.models;
import java.util.List;

public class Album {
    private String id;
    private String name;
    private String artist;
    private List<Song> songs;
    public Album() {
    }
    public Album(String id, String name, String artist, List<Song> songs)
    {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.songs = songs;
    }
    public String getId() {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    public List<Song> getSongs() {
        return songs;
    }
    public void setSongs(List<Song> songs)
    {
        this.songs = songs;
    }
}
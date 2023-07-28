package com.melolingo.app.models;
import java.util.List;

public class Playlist {
    private String id;
    private String name;
    private List<Song> songs;
    public Playlist() {
    }
    public Playlist(String id, String name, List<Song> songs)
    {
        this.id = id;
        this.name = name;
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
    public List<Song> getSongs() {
        return songs;
    }
    public void setSongs(List<Song> songs)
    {
        this.songs = songs;
    }
}
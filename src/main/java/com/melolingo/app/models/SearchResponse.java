package com.melolingo.app.models;
import java.util.List;
public class SearchResponse {
    private List<Song> songs;
    public SearchResponse() {
    }
    public SearchResponse(List<Song> songs)
    {
        this.songs = songs;
    }
    public List<Song> getSongs() {
        return songs;
    }
    public void setSongs(List<Song> songs)
    {
        this.songs = songs;
    }
}
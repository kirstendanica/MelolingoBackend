package com.melolingo.app.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Playlist {
    @Id
    private String id;
    private String name;

    // Spotify data fields
    private String spotifyId;
    private String spotifyUri;

    @OneToMany
    private List < Song > songs;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List < Song > getSongs() {
        return songs;
    }

    public void setSongs(List < Song > songs) {
        this.songs = songs;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getSpotifyUri() {
        return spotifyUri;
    }

    public void setSpotifyUri(String spotifyUri) {
        this.spotifyUri = spotifyUri;
    }
}
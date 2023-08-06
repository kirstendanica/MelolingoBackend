package com.melolingo.app.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private String spotifyId;
    private int duration;
    private int popularity;
    private Date releaseDate;
    private String lyrics;

    public String getLyrics() {
        return lyrics;
    }

    public Song() {
    }

    public Song(String title, String artist, String album, String genre, String spotifyId, int duration, int popularity, Date releaseDate)
    {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.spotifyId = spotifyId;
        this.duration = duration;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album)
    {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId)
    {
        this.spotifyId = spotifyId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity)
    {
        this.popularity = popularity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getSpotifyIdAsString() {
        return spotifyId;
    }

    private String language;
}
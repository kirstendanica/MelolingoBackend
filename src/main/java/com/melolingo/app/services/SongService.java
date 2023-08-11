package com.melolingo.app.services;

import com.melolingo.app.models.Song;
import com.melolingo.app.repo.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class SongService {
    @Autowired
    private SongRepo songRepository;

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getSongsByTitle(String title) {
        return songRepository.findByTitle(title);
    }

    public List<Song> getSongsByArtist(String artist) {
        return songRepository.findByArtist(artist);
    }

    public List<Song> getSongsByGenre(String genre) {
        return songRepository.findByGenre(genre);
    }

    // Add this method to get recently played songs
    public List<Song> getRecentlyPlayedSongs() {
        // Implement the logic to retrieve recently played songs here
        // For now, you can return an empty list
        return new ArrayList<>();
    }
}
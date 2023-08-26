package com.melolingo.app.services;

import com.melolingo.app.models.Language;
import com.melolingo.app.models.Playlist;
import com.melolingo.app.repo.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepo playlistRepo;

    @Autowired
    public PlaylistService(PlaylistRepo playlistRepo) {
        this.playlistRepo = playlistRepo;
    }

    public List<Playlist> getLanguageSpecificPlaylists(Language.LanguageEnum language) {
        return playlistRepo.findByLanguage(language);
    }

}
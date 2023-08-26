package com.melolingo.app.repo;

import com.melolingo.app.models.Language;
import com.melolingo.app.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepo extends JpaRepository<Playlist, Long> {

    List<Playlist> findByLanguage(Language.LanguageEnum language);
}

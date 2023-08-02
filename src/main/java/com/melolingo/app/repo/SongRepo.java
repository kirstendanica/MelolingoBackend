package com.melolingo.app.repo;

import com.melolingo.app.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SongRepo extends JpaRepository<Song, Long> {
    List<Song> findByTitle(String title);
    List<Song> findByArtist(String artist);
    List<Song> findByGenre(String genre);

}
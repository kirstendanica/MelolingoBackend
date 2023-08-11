package com.melolingo.app.controller;

import com.melolingo.app.models.SearchResponse;
import com.melolingo.app.models.Song;
import com.melolingo.app.services.SpotifyService;
import com.melolingo.app.services.SongService;
import com.melolingo.app.services.TranslateService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private final SpotifyService spotifyService;
    private final SongService songService;
    private final TranslateService translateService;

    public SongController(SpotifyService spotifyService, SongService songService, TranslateService translateService) {
        this.spotifyService = spotifyService;
        this.songService = songService;
        this.translateService = translateService;
    }

    @GetMapping("/search")
    public void searchSongs(@RequestParam("query") String query) {
        Call<SearchResponse> call = spotifyService.searchSongs(query, "track");
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()) {
                    SearchResponse searchResponse = response.body();
                    // Process the search response
                } else {
                    // Handle error response
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    @GetMapping("/{songId}/lyrics")
    public ResponseEntity<Map<String, String>> getSongLyricsWithTranslation(
            @PathVariable Long songId,
            @RequestParam String targetLanguage
    ) {
        Song song = songService.getSongById(songId);
        if (song == null) {
            return ResponseEntity.notFound().build();
        }

        String originalLyrics = song.getLyrics();
        String translatedLyrics = translateService.translateText(originalLyrics, "en", targetLanguage);

        Map<String, String> lyricsMap = new HashMap<>();
        lyricsMap.put("original", originalLyrics);
        lyricsMap.put("translated", translatedLyrics);

        return ResponseEntity.ok(lyricsMap);
    }

    @GetMapping("/recently-played")
    public ResponseEntity<List<Song>> getRecentlyPlayedSongs() {
        List<Song> recentlyPlayedSongs = songService.getRecentlyPlayedSongs();
        return ResponseEntity.ok(recentlyPlayedSongs);
    }

    @PostMapping("/{songId}/play")
    public ResponseEntity<String> playSong(@PathVariable Long songId) {
        Song song = songService.getSongById(songId);
        if (song == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the lastPlayedAt timestamp
        song.setLastPlayedAt(new Date());
        songService.saveSong(song);

        return ResponseEntity.ok("Song played successfully.");
    }
}
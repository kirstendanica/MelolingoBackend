package com.melolingo.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.melolingo.app.models.SearchResponse;
import com.melolingo.app.services.SpotifyService;
import retrofit2.Call;
import retrofit2.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private final SpotifyService spotifyService;

    @Autowired
    public SearchController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/search")
    public ResponseEntity<SearchResponse> search(@RequestParam String query, @RequestParam String type) {
        Call<SearchResponse> searchCall = spotifyService.searchSongs(query, type);
        try {
            Response<SearchResponse> response = searchCall.execute();
            if (response.isSuccessful()) {
                SearchResponse searchResponse = response.body();
                return ResponseEntity.ok(searchResponse);
            } else {

                // Handle error & exception
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
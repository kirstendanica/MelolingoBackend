package com.melolingo.app.controller;

import com.melolingo.app.services.SpotifyService;
import com.melolingo.app.models.SearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController @RequestMapping("/api/songs")
public class SongController {
    private final SpotifyService spotifyService;

    public SongController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
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
}

package com.melolingo.app.services;

import com.melolingo.app.services.SpotifyService;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import com.melolingo.app.models.Song;
import com.melolingo.app.models.SearchResponse;
import com.melolingo.app.models.Album;
import com.melolingo.app.models.Artist;
import com.melolingo.app.models.Playlist;

public class SpotifyApiClient {
    private static final String BASE_URL = "https://api.spotify.com/";
    private static SpotifyService spotifyService;

    public SpotifyApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        spotifyService = retrofit.create(SpotifyService.class);
    }

    public SearchResponse searchSongs(String query, String type) {
        try {
            Call<SearchResponse> call = spotifyService.searchSongs(query, type);
            retrofit2.Response<SearchResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                // Handle error
                return null;
            }
        } catch (Exception e) {
            // Handle exception
            return null;
        }
    }
    public Call<Song> getSong(String songId) {
        return spotifyService.getSong(songId);
    }
    public Call<Artist> getArtist(String artistId) {
        return spotifyService.getArtist(artistId);
    }
    public Call<Album> getAlbum(String albumId) {
        return spotifyService.getAlbum(albumId);
    }
    public Call<Playlist> getPlaylist(String playlistId) {
        return spotifyService.getPlaylist(playlistId);
    }
}

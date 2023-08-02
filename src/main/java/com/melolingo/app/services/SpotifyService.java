package com.melolingo.app.services;
import com.melolingo.app.models.Album;
import com.melolingo.app.models.Artist;
import com.melolingo.app.models.Playlist;
import com.melolingo.app.models.SearchResponse;
import com.melolingo.app.models.Song;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpotifyService {
    // Define API endpoints
    @GET("v1/search")
    Call<SearchResponse> searchSongs(@Query("q") String query, @Query("type") String type);
    @GET("v1/tracks/{id}")
    Call<Song> getSong(@Path("id") String songId);
    @GET("v1/artists/{id}")
    Call<Artist> getArtist(@Path("id") String artistId);
    @GET("v1/albums/{id}")
    Call<Album> getAlbum(@Path("id") String albumId);
    @GET("v1/playlists/{id}")
    Call<Playlist> getPlaylist(@Path("id") String playlistId);
}
package com.melolingo.app.security;

import com.melolingo.app.services.SpotifyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class SpotifyConfig {

    @Bean
    public SpotifyService spotifyService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SpotifyService.class);
    }
}
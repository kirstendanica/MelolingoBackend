package com.melolingo.app.services;

import com.melolingo.app.models.Language;
import com.melolingo.app.models.Playlist;
import com.melolingo.app.repo.PlaylistRepo;
import com.melolingo.app.services.PlaylistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistServiceTest {

    @Mock
    private PlaylistRepo playlistRepo;

    @InjectMocks
    private PlaylistService playlistService;

    private List<Playlist> mockPlaylists;

    @Before
    public void setUp() {
        // Create mock playlists
        mockPlaylists = new ArrayList<>();
        mockPlaylists.add(new Playlist(/* Initialize with mock data */));
        // Add more mock playlists as needed
    }

    @Test
    public void testGetLanguageSpecificPlaylists_ValidLanguage() {
        // Mock the behavior of playlistRepo.findByLanguage
        when(playlistRepo.findByLanguage(Language.LanguageEnum.ENGLISH)).thenReturn(mockPlaylists);

        // Call the service method
        List<Playlist> playlists = playlistService.getLanguageSpecificPlaylists(Language.LanguageEnum.ENGLISH);

        // Assert the result
        assertEquals(mockPlaylists, playlists);
    }
}
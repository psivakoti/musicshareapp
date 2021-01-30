package com.galvanize.musicshare.service;
import com.galvanize.musicshare.entity.Playlist;
import com.galvanize.musicshare.entity.PlaylistSongMapping;
import com.galvanize.musicshare.repository.PlaylistRepository;
import com.galvanize.musicshare.repository.PlaylistSongMappingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class PlaylistServiceTest {

    @InjectMocks
    private PlaylistService playlistService;

    @Mock
    private PlaylistSongMappingRepository playlistSongMappingRepository;

    @Mock
    PlaylistRepository playlistRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPlaylist_Success() {
        Playlist playlistExpected = new Playlist();
        playlistExpected.setPlaylistName("My Playlist");
        when(playlistRepository.save(playlistExpected)).thenReturn(playlistExpected);
        Playlist playlist = playlistService.createPlaylist(playlistExpected);
       assertNotNull(playlist);
       assertEquals(playlist.getPlaylistName(), playlistExpected.getPlaylistName());
    }

    @Test
    public void addSongToEmptyPlayList_returnCountAsOne() {
        when(playlistSongMappingRepository.save(any())).thenReturn(PlaylistSongMapping.builder().build());

        List<PlaylistSongMapping> list = new ArrayList<>();
        list.add(PlaylistSongMapping.builder().build());

        when(playlistSongMappingRepository.findByPlaylistName(anyString())).thenReturn(list);

        assertEquals(1, playlistService.addSongToPlayList("workout", "It is good"));
    }


}
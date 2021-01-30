package com.galvanize.musicshare.service;
import com.galvanize.musicshare.entity.Playlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistServiceTest {

    @InjectMocks
    private PlaylistService playlistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPlaylist_Success() {
        Playlist playlist = playlistService.createPlaylist();
       assertNotNull(playlist);
    }

}
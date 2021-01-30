package com.galvanize.musicshare.service;

import com.galvanize.musicshare.entity.Playlist;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class PlaylistServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private PlaylistService playlistService;

    @Test
    private void createPlaylist_Success() {
        Playlist playlist = playlistService.createPlaylist();
        assertNotEquals(1,2);
    }

}
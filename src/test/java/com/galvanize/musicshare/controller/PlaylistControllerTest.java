package com.galvanize.musicshare.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaylistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createPlaylistReturnsEmptyList() throws Exception {
        mockMvc.perform(
                post("/api/v1/playlist/{name}", "My Playlist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.playlistName").exists())
                .andExpect(jsonPath("$.playlistName").value("My Playlist"));
    }

    @Test
    public void addSongToEmptyPlayList_returnCountAsOne() throws Exception {

        mockMvc.perform(put("/api/v1/playlist/{playlistName}/song/{songName}", "workout", "It is my life"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(1));

    }
}

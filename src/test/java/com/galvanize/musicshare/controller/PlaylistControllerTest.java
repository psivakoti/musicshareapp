package com.galvanize.musicshare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.musicshare.entity.Playlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaylistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createPlaylist_ReturnStatus_201() throws Exception {
        Playlist playlist = new Playlist();
        playlist.setPlaylistName("My Playlist");
        mockMvc.perform(
                post("/api/v1/playlist/")
                .content(objectMapper.writeValueAsString(playlist))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
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

    @Test
    public void createPlaylist_ReturnStatus_400() throws Exception {
        Playlist playlist = new Playlist();

        mockMvc.perform(
                post("/api/v1/playlist/")
                .content(objectMapper.writeValueAsString(playlist))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Playlist name required"));
    }
}

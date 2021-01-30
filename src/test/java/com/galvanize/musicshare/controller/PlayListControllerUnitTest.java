package com.galvanize.musicshare.controller;

import com.galvanize.musicshare.service.PlaylistService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PlayListControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlaylistService playlistService;

    //put /playlist/{playlist_id}/song/{song_id} 201
    @Test
    public void addSongToEmptyPlayList_returnCountAsOne() throws Exception {

        when(playlistService.addSongToPlayList(anyString(), anyString())).thenReturn(1);

        mockMvc.perform(put("/api/v1/playlist/{playlistName}/song/{songName}", "workout", "It is a good day"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(1));

    }

    @Test
    public void removeSongFromPlaylist_return204() throws Exception {
        doNothing().when(playlistService).removeSongFromPlaylist(anyString(),anyString());
        mockMvc.perform(delete("/api/v1/playlist/{playlistName}/song/{songName}", "workout", "It is a good day"))
                .andExpect(status().isNoContent());

    }

}

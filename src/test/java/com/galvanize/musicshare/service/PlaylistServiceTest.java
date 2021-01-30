package com.galvanize.musicshare.service;

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

    //@InjectMocks


    @Test
    private void createPlaylist_Success() {

    }

}
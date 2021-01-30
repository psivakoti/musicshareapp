package com.galvanize.musicshare.service;
import com.galvanize.musicshare.entity.Playlist;
import com.galvanize.musicshare.entity.PlaylistSongMapping;
import com.galvanize.musicshare.repository.PlaylistRepository;
import com.galvanize.musicshare.repository.PlaylistSongMappingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class PlaylistServiceTest {

    @InjectMocks
    private PlaylistService playlistService;

    @Mock
    private PlaylistSongMappingRepository playlistSongMappingRepository;

    @Mock
    PlaylistRepository playlistRepository;

    @Captor
    private ArgumentCaptor<PlaylistSongMapping> deleteArgs;

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

    @Test
    public void removeSongFromPlayList() {
        PlaylistSongMapping playlistSongMapping = PlaylistSongMapping.builder().playlistName("playlist1").songName("test").build();
        when(playlistSongMappingRepository.findByPlaylistNameAndSongName(anyString(),anyString())).thenReturn(playlistSongMapping);
        doNothing().when(playlistSongMappingRepository).delete(any(PlaylistSongMapping.class));
        playlistService.removeSongFromPlaylist("playlist1","test");
        verify(playlistSongMappingRepository).delete(deleteArgs.capture());

        PlaylistSongMapping args = deleteArgs.getValue();
       assertEquals("playlist1",args.getPlaylistName());
       assertEquals("test",args.getSongName());
    }
}
package com.galvanize.musicshare.service;

import com.galvanize.musicshare.entity.Playlist;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    public Integer addSongToPlayList(String playListName, String songName) {
        return 0;
    }

    public Playlist createPlaylist() {
        return new Playlist();
    }
}

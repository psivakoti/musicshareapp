package com.galvanize.musicshare.controller;

import com.galvanize.musicshare.entity.Playlist;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/playlist")

public class PlaylistController {

    @PostMapping
    public Playlist createPlaylist(){
        Playlist playlist = new Playlist();
        playlist.setPlaylistName("My Playlist");
        return playlist;
    }
}

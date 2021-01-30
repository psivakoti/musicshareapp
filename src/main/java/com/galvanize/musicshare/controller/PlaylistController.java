package com.galvanize.musicshare.controller;

import com.galvanize.musicshare.entity.Playlist;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.galvanize.musicshare.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/playlist")
@AllArgsConstructor
public class PlaylistController {

    private PlaylistService playlistService;

    @PostMapping
    public Playlist createPlaylist(){
        Playlist playlist = new Playlist();
        playlist.setPlaylistName("My Playlist");
        return playlist;
    }

    @PutMapping("/{playlistName}/song/{songName}")
    public Integer addSongToPlayList(@PathVariable String playlistName,
                                     @PathVariable String songName) {
        return playlistService.addSongToPlayList(playlistName, songName);
    }
}

package com.galvanize.musicshare.controller;

import com.galvanize.musicshare.entity.Playlist;
import com.galvanize.musicshare.service.PlaylistService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/playlist")
@AllArgsConstructor
public class PlaylistController {

    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Object> createPlaylist(@RequestBody Playlist playlist) {

        if(null != playlist.getPlaylistName()){
            return new ResponseEntity<>(playlistService.createPlaylist(playlist), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Playlist name required", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{playlistName}/song/{songName}")
    public Integer addSongToPlayList(@PathVariable String playlistName,
                                     @PathVariable String songName) {
        return playlistService.addSongToPlayList(playlistName, songName);
    }

    @DeleteMapping("/{playlistName}/song/{songName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSongFromPlaylist(@PathVariable String playlistName,
                                     @PathVariable String songName) {
       playlistService.removeSongFromPlaylist(playlistName, songName);
    }
}

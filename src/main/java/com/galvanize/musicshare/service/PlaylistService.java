package com.galvanize.musicshare.service;

import com.galvanize.musicshare.entity.Playlist;
import com.galvanize.musicshare.entity.PlaylistSongMapping;
import com.galvanize.musicshare.repository.PlaylistSongMappingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaylistService {

    private PlaylistSongMappingRepository playlistSongMappingRepository;

    public Integer addSongToPlayList(String playListName, String songName) {
        PlaylistSongMapping playlistSongMapping = PlaylistSongMapping.builder()
                .playlistName(playListName)
                .songName(songName).build();

        playlistSongMappingRepository.save(playlistSongMapping);
        return playlistSongMappingRepository.findByPlaylistName(playListName).size();
    }

    public Playlist createPlaylist() {
        return new Playlist();
    }

    public void removeSongFromPlaylist(String playListName, String songName) {
    }
}

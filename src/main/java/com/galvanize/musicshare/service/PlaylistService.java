package com.galvanize.musicshare.service;

import com.galvanize.musicshare.entity.Playlist;
import com.galvanize.musicshare.entity.PlaylistSongMapping;
import com.galvanize.musicshare.repository.PlaylistRepository;
import com.galvanize.musicshare.repository.PlaylistSongMappingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    private PlaylistSongMappingRepository playlistSongMappingRepository;

    public Integer addSongToPlayList(String playListName, String songName) {
        PlaylistSongMapping playlistSongMapping = PlaylistSongMapping.builder()
                .playlistName(playListName)
                .songName(songName).build();

        playlistSongMappingRepository.save(playlistSongMapping);
        return playlistSongMappingRepository.findByPlaylistName(playListName).size();
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public void removeSongFromPlaylist(String playListName, String songName) {
    }
}

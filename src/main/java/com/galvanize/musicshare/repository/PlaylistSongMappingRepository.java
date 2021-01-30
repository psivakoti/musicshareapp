package com.galvanize.musicshare.repository;

import com.galvanize.musicshare.entity.PlaylistSongMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistSongMappingRepository extends JpaRepository<PlaylistSongMapping, Long> {
    List<PlaylistSongMapping> findByPlaylistName(String anyString);
}

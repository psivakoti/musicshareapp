package com.galvanize.musicshare.repository;

import com.galvanize.musicshare.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}

package com.galvanize.musicshare.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class PlaylistSongMapping {
    @Id
    @GeneratedValue
    private Long id;
    private String playlistName;
    private String songName;
}

package entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Playlist {
    @Id
    private String playlistName;
}

package entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue
    private Long songId;
    private String songName;
}

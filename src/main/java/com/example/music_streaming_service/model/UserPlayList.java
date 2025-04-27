package com.example.music_streaming_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userPlaylist_tbl")
public class UserPlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id")
    private int listId;

    private String listName;

    private Timestamp createdDate;

    private Timestamp updatedDate;


    // Many-to-many relationship with Song through UserPlaylistSong
    @ManyToMany
    @JoinTable(
            name = "user_playlist_tbl_song_list",
            joinColumns = @JoinColumn(name = "user_playlist_list_id"),
            inverseJoinColumns = @JoinColumn(name = "song_list_song_id")
    )
    private List<Song> songList;


    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;
}

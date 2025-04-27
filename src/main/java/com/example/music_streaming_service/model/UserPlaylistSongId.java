package com.example.music_streaming_service.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class UserPlaylistSongId implements Serializable {

    @Column(name = "user_playlist_list_id")
    private int userPlayListListId;

    @Column(name = "song_list_song_id")
    private int songListSongId;

}

package com.example.music_streaming_service.model;

import javax.persistence.*;

@Entity
@Table(name = "user_playlist_tbl_song_list")
public class UserPlaylistSong {

    @EmbeddedId
    private UserPlaylistSongId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userPlayListListId")
    @JoinColumn(name = "user_playlist_list_id")
    private UserPlayList userPlaylist;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("songListSongId")
    @JoinColumn(name = "song_list_song_id")
    private Song song;
}

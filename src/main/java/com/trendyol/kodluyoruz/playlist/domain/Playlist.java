package com.trendyol.kodluyoruz.playlist.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Playlist {
    private String userId;

    public Playlist(String userId) {
        this.userId = userId;
    }
}

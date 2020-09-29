package com.trendyol.kodluyoruz.playlist.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Playlist {
    private String userId;
    private List<Track> tracks;
    private int trackCount;

    public Playlist(String userId) {
        this.userId = userId;
        this.tracks = new ArrayList<>();
        this.trackCount = 0;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
        this.trackCount++;
    }
}

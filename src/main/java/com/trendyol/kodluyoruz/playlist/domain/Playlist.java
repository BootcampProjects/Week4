package com.trendyol.kodluyoruz.playlist.domain;

import com.trendyol.kodluyoruz.playlist.exception.ResourceNotFoundException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Playlist {
    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Track> tracks;
    private int trackCount;
    private String userId;

    public Playlist(String name, String description, String userId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.followersCount = 0;
        this.tracks = new ArrayList<>();
        this.trackCount = 0;
        this.userId = userId;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
        this.trackCount++;
    }

    public void removeTrack(String trackId) {
        Track track = this.tracks.stream().filter(t -> t.getId().equals(trackId))
                .findFirst()
                .orElse(null);

        if (track != null) {
            this.tracks.remove(track);
            this.trackCount--;
        } else
            throw new ResourceNotFoundException("Document with the given trackId not found");
    }

    public void followPlaylist() {
        this.followersCount++;
    }
}

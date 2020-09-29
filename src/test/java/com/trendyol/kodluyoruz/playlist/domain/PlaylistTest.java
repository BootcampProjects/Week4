package com.trendyol.kodluyoruz.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaylistTest {

    @Test
    public void should_create_playlist() {
        // Arrange
        Playlist sut;
        String userId = "user123";

        // Act
        sut = new Playlist(userId);

        // Assert
        assertThat(sut.getUserId()).isEqualTo(userId);
    }

    @Test
    public void should_add_track() {
        // Arrange
        Playlist sut = new Playlist("testUser1");
        Track track = new Track("Track1", "3.04", "Artist1");

        // Act
        sut.addTrack(track);

        // Assert
        assertThat(sut.getTracks().get(0)).isEqualTo(track);
        assertThat(sut.getTrackCount()).isEqualTo(1);
    }
}

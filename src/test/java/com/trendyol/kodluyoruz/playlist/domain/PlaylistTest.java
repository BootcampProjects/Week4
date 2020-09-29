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
}

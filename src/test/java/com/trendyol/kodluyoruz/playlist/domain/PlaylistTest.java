package com.trendyol.kodluyoruz.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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

    @Test
    public void should_remove_track() {
        // Arrange
        Playlist sut = new Playlist("testUser1");
        Track track = new Track("Track1", "3.04", "Artist1");

        // Act
        sut.addTrack(track);
        sut.removeTrack(track);

        // Assert
        assertThat(sut.getTrackCount()).isEqualTo(0);
        assertThat(sut.getTracks().size()).isEqualTo(0);
    }

    @Test
    public void removeTracks_should_illegal_argument_exception_when_remove_not_exists_track() {
        // Arrange
        Playlist sut = new Playlist("testUser1");
        Track track = new Track("Track1", "3.04", "Artist1");
        Track track2 = new Track("Track2", "2.47", "Artist2");

        // Act
        sut.addTrack(track);
        Throwable throwable = catchThrowable(() -> sut.removeTrack(track2));

        // Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Track not exists in playlist.");
        assertThat(sut.getTrackCount()).isEqualTo(1);
        assertThat(sut.getTracks().size()).isEqualTo(1);
    }

    @Test
    public void followPlaylist_should_increase_followers_count() {
        // Arrange
        Playlist sut = new Playlist("testUser1");

        // Act
        sut.followPlaylist();
        sut.followPlaylist();

        // Assert
        assertThat(sut.getFollowersCount()).isEqualTo(2);
    }
}

package com.trendyol.kodluyoruz.playlist.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PlaylistTest {

    Playlist sut;
    Track track;

    @BeforeEach
    public void setUp() {
        sut = new Playlist("Playlist Test", "Desc Playlist Test", "testUserId123");
        track = new Track("Track Test", "3.10", "Artist Test");
    }

    @Test
    public void should_create_playlist() {
        // Arrange
        // defined at beforeEach

        // Act
        // created at beforeEach

        // Assert
        assertThat(sut.getUserId()).isEqualTo("testUserId123");
    }

    @Test
    public void should_add_track() {
        // Arrange
        // defined at beforeEach

        // Act
        sut.addTrack(track);

        // Assert
        assertThat(sut.getTracks().get(0)).isEqualTo(track);
        assertThat(sut.getTrackCount()).isEqualTo(1);
    }

    @Test
    public void should_remove_track() {
        // Arrange
        // defined at beforeEach

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
        // defined at beforeEach
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
        // defined at beforeEach

        // Act
        sut.followPlaylist();
        sut.followPlaylist();

        // Assert
        assertThat(sut.getFollowersCount()).isEqualTo(2);
    }
}

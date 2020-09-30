package com.trendyol.kodluyoruz.playlist.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PlaylistTest {

    Playlist sut;
    Track track;

    @BeforeEach
    public void setUp() {
        sut = new Playlist("Playlist Test", "Desc Playlist Test", "testUserId123");
        track = new Track("testTrack123", "Track Test", "3.10", "Artist Test");
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
        sut.removeTrack("testTrack123");

        // Assert
        assertThat(sut.getTrackCount()).isEqualTo(0);
        assertThat(sut.getTracks().size()).isEqualTo(0);
    }

    @Test
    public void removeTracks_should_illegal_argument_exception_when_remove_not_exists_track() {
        // Arrange
        // defined at beforeEach

        // Act
        sut.addTrack(track);
        Throwable throwable = catchThrowable(() -> sut.removeTrack("testTrack234"));

        // Assert
        assertThat(throwable).isInstanceOf(NoSuchElementException.class);
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

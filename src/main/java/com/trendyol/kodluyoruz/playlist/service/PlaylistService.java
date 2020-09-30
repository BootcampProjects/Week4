package com.trendyol.kodluyoruz.playlist.service;

import com.trendyol.kodluyoruz.playlist.domain.Playlist;
import com.trendyol.kodluyoruz.playlist.domain.Track;
import com.trendyol.kodluyoruz.playlist.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void createPlaylist(Playlist playlist) {
        playlistRepository.insert(playlist);
    }

    public Playlist findById(String id) {
        return playlistRepository.findById(id);
    }

    public List<Playlist> findAllByUserId(String userId) {
        return playlistRepository.findAllByUserId(userId);
    }

    public void deletePlaylist(String id) {
        playlistRepository.delete(id);
    }

    public void addTrackToPlaylist(String id, Track track) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findByIdOptional(id);
        if (optionalPlaylist.isEmpty())
            return;
        Playlist playlist = optionalPlaylist.get();
        playlist.addTrack(track);
        playlistRepository.update(playlist);
    }

    public void removeTrackToPlaylist(String id, Track track) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findByIdOptional(id);
        if (optionalPlaylist.isEmpty())
            return;
        Playlist playlist = optionalPlaylist.get();
        playlist.removeTrack(track);
        playlistRepository.update(playlist);
    }
}

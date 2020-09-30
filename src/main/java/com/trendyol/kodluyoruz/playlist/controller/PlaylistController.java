package com.trendyol.kodluyoruz.playlist.controller;

import com.trendyol.kodluyoruz.playlist.contract.request.CreatePlaylistRequest;
import com.trendyol.kodluyoruz.playlist.domain.Playlist;
import com.trendyol.kodluyoruz.playlist.domain.Track;
import com.trendyol.kodluyoruz.playlist.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody CreatePlaylistRequest request) {
        Playlist playlist = new Playlist(request.getName(), request.getDescription(), request.getUserId());
        playlistService.createPlaylist(playlist);
        URI location = URI.create(String.format("/playlists/%s/", playlist.getId()));

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> findPlaylistById(@PathVariable String id) {
        return ResponseEntity.ok(playlistService.findById(id));
    }

    @GetMapping("/u/{userId}")
    public ResponseEntity<List<Playlist>> findAllPlaylistByUserId(@PathVariable String userId, @RequestParam(required = false, defaultValue = "0") String offset, @RequestParam(required = false, defaultValue = "5") String limit) {
        // TODO : pagination
        return ResponseEntity.ok(playlistService.findAllByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/t")
    public ResponseEntity<Void> addTrackToPlaylist(@PathVariable String id, @RequestBody Track track) {
        playlistService.addTrackToPlaylist(id, track);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/t/{trackId}")
    public ResponseEntity<Void> removeTrackToPlaylist(@PathVariable String id, @PathVariable String trackId) {
        playlistService.removeTrackToPlaylist(id, trackId);
        return ResponseEntity.noContent().build();
    }
}

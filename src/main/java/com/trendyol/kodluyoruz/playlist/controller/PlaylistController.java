package com.trendyol.kodluyoruz.playlist.controller;

import com.trendyol.kodluyoruz.playlist.contract.request.CreatePlaylistRequest;
import com.trendyol.kodluyoruz.playlist.contract.request.UpdatePlaylistTrackRequest;
import com.trendyol.kodluyoruz.playlist.domain.Playlist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/playlists")
public class PlaylistController {

    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody CreatePlaylistRequest request) {
        String id = "newPostId123";
        URI location = URI.create(String.format("/playlists/%s/", id));

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> findPlaylistById(@PathVariable String id) {

        return ResponseEntity.ok().build();
    }

    @GetMapping("/u/{userId}")
    public ResponseEntity<List<Playlist>> findAllPlaylistByUserId(@PathVariable String userId, @RequestParam(required = false, defaultValue = "0") String offset, @RequestParam(required = false, defaultValue = "5") String limit) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String id) {

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/a")
    public ResponseEntity<Void> addTrackToPlaylist(@PathVariable String id, @RequestBody UpdatePlaylistTrackRequest request) {

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/r")
    public ResponseEntity<Void> removeTrackToPlaylist(@PathVariable String id, @RequestBody UpdatePlaylistTrackRequest request) {

        return ResponseEntity.noContent().build();
    }
}

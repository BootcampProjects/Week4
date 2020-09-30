package com.trendyol.kodluyoruz.playlist.repository;

import com.couchbase.client.core.error.DocumentNotFoundException;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.trendyol.kodluyoruz.playlist.domain.Playlist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlaylistRepository {
    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public void insert(Playlist playlist) {
        playlistCollection.insert(playlist.getId(), playlist);
    }

    public void update(Playlist playlist) {
        playlistCollection.replace(playlist.getId(), playlist);
    }

    public void delete(String id) {
        playlistCollection.remove(id);
    }

    public Playlist findById(String id) {
        GetResult getResult = playlistCollection.get(id);
        return getResult.contentAs(Playlist.class);
    }

    public Optional<Playlist> findByIdOptional(String id) {
        try {
            GetResult getResult = playlistCollection.get(id);
            Playlist playlist = getResult.contentAs(Playlist.class);
            return Optional.of(playlist);
        } catch (DocumentNotFoundException exception) {
            return Optional.empty();
        }
    }

    public List<Playlist> findAllByUserId(String userId) {
        String statement = String.format("Select id, name, description, followersCount, tracks, trackCount, userId from playlist where userId = \"%s\"", userId);
        QueryResult queryResult = couchbaseCluster.query(statement);
        return queryResult.rowsAs(Playlist.class);
    }
}

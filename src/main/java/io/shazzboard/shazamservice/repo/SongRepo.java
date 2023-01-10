package io.shazzboard.shazamservice.repo;

import io.shazzboard.shazamservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepo extends JpaRepository<Song, Long> {
    Optional<Song> findSongById(Long id);
    Song findSongByNameAndArtist(String name, String artist);
}

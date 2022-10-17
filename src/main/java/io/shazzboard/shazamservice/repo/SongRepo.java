package io.shazzboard.shazamservice.repo;

import io.shazzboard.shazamservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Long> {

}

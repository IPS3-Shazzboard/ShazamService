package io.shazzboard.shazamservice.service;

import io.shazzboard.shazamservice.model.Song;
import io.shazzboard.shazamservice.repo.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShazamService {

    private final SongRepo songRepo;

    @Autowired
    public ShazamService(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    public List<Song> listAllSongs() {
        return songRepo.findAll();
    }

    public Optional<Song> findSong(Long id) {
        return songRepo.findSongById(id);
    }

    public Song findSongByNameAndArtist(String name, String artist) { return songRepo.findSongByNameAndArtist(name, artist); }

    public Song addSong(Song song) {
        return songRepo.save(song);
    }

    public void deleteSong(Long id) {
        songRepo.deleteById(id);
    }


}

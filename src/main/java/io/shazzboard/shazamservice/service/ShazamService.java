package io.shazzboard.shazamservice.service;

import io.shazzboard.shazamservice.model.Song;
import io.shazzboard.shazamservice.repo.SongRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShazamService {

    private final SongRepo songRepo;

    public ShazamService(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    public List<Song> listAllSongs() {
        return songRepo.findAll();
    }
}

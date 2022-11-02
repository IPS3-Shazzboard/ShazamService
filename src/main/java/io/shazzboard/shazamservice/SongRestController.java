package io.shazzboard.shazamservice;

import io.shazzboard.shazamservice.model.Song;
import io.shazzboard.shazamservice.service.ShazamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongRestController {

    private final ShazamService shazamService;

    public SongRestController(ShazamService shazamService){
        this.shazamService = shazamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = shazamService.listAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        Song newSong = shazamService.addSong(song);
        return new ResponseEntity<>(newSong, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSong (@PathVariable("id") Long id) {
        shazamService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

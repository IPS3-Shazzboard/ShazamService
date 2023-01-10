package io.shazzboard.shazamservice;

import io.shazzboard.shazamservice.model.Song;
import io.shazzboard.shazamservice.service.ShazamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
        if (!StringUtils.hasText(song.getName()) || !StringUtils.hasText(song.getArtist()) ||
                !StringUtils.hasText(song.getDuration()) || !StringUtils.hasText(song.getCoverArt())) {
            return new ResponseEntity<>(song, HttpStatus.BAD_REQUEST);
        }
        if (shazamService.findSongByNameAndArtist(song.getName(), song.getArtist()) != null) {
            return new ResponseEntity<>(song, HttpStatus.CONFLICT);
        }
        else {
            Song newSong = shazamService.addSong(song);
            return new ResponseEntity<>(newSong, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSong (@PathVariable("id") Long id) {
        shazamService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

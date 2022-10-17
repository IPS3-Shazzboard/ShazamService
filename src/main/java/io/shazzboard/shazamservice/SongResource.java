package io.shazzboard.shazamservice;

import io.shazzboard.shazamservice.model.Song;
import io.shazzboard.shazamservice.service.ShazamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("song")
public class SongResource {

    private final ShazamService shazamService;

    public SongResource(ShazamService shazamService){
        this.shazamService = shazamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = shazamService.listAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}

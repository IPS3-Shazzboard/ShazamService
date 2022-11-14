package io.shazzboard.shazamservice.serviceTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.shazzboard.shazamservice.SongRestController;
import io.shazzboard.shazamservice.model.Song;
import io.shazzboard.shazamservice.service.ShazamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(SongRestController.class)
public class ShazamServiceTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ShazamService service;

    @Test
    public void getSongs_returnCorrectJsonArray()
        throws Exception {
        Song song = new Song("song2", "Blur", "2:03", "url");
        List<Song> allSongs = Arrays.asList(song);

        given(service.listAllSongs()).willReturn(allSongs);

        mvc.perform(MockMvcRequestBuilders.get("/song/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("song2"))
                .andExpect(jsonPath("$[0].artist").value("Blur"))
                .andExpect(jsonPath("$[0].duration").value("2:03"))
                .andExpect(jsonPath("$[0].coverArt").value("url"));
    }

    @Test
    public void addSong_correctlyAddedSong()
        throws Exception {
        Song song = new Song("songName", "artistName", "1:23", "url");

        given(service.addSong(song)).willReturn(song);

        mvc.perform(MockMvcRequestBuilders.post("/song/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(song)))
                .andExpect(status().isCreated());
    }

    public static String toJson(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}

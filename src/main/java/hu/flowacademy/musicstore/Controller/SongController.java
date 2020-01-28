package hu.flowacademy.musicstore.Controller;

import hu.flowacademy.musicstore.Model.Artist;
import hu.flowacademy.musicstore.Model.Song;
import hu.flowacademy.musicstore.Service.ArtistService;
import hu.flowacademy.musicstore.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongController {

    @Autowired
    SongService songService;

    @RequestMapping(value = "/api/songs/{id}", method = RequestMethod.PUT)
    public Song updateSongs(@PathVariable(value = "id")Long id, @RequestBody Song song) {
        return songService.songUpdate(id, song);
    }

    @RequestMapping(value = "/api/songs", method = RequestMethod.GET)
    public Iterable<Song> getSongs() {
        return songService.getSong();
    }

    @RequestMapping(value = "/api/songs/{id}", method = RequestMethod.DELETE)
    public void deleteSong(@PathVariable(value = "id")Long id) {
        songService.deleteSong(id);
    }

    @RequestMapping(value = "/api/songs", method = RequestMethod.POST)
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @RequestMapping(value = "/api/songs/{id}", method = RequestMethod.GET)
    public Optional<Song> findSong(@PathVariable(value = "id")Long id) {
        return songService.findOneSong(id);
    }

}

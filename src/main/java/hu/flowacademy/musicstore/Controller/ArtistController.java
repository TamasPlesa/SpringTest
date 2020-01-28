package hu.flowacademy.musicstore.Controller;


import hu.flowacademy.musicstore.Model.Artist;
import hu.flowacademy.musicstore.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @RequestMapping(value = "/api/artists/{id}", method = RequestMethod.PUT)
    public Artist updateArtist(@PathVariable(value = "id")Long id, @RequestBody Artist artist) {
        return artistService.artistUpdate(id, artist);
    }

    @RequestMapping(value = "/api/artists", method = RequestMethod.GET)
    public Iterable<Artist> getArtists() {
        return artistService.getArtist();
    }

    @RequestMapping(value = "/api/artists", method = RequestMethod.DELETE)
    public void deleteArtist(@PathVariable(value = "id")Long id) {
        artistService.deleteArtist(id);
    }

    @RequestMapping(value = "/api/artists", method = RequestMethod.POST)
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }

    @RequestMapping(value = "/api/artists/{id}", method = RequestMethod.GET)
    public Optional<Artist> findArtist(@PathVariable(value = "id")Long id) {
        return artistService.findOneArtist(id);
    }

}

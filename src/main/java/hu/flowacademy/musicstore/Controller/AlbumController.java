package hu.flowacademy.musicstore.Controller;

import hu.flowacademy.musicstore.Model.Album;
import hu.flowacademy.musicstore.Model.Artist;
import hu.flowacademy.musicstore.Service.AlbumService;
import hu.flowacademy.musicstore.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping(value = "/api/albums/{id}", method = RequestMethod.PUT)
    public Album updateAlbum(@PathVariable(value = "id")Long id, @RequestBody Album album) {
        return albumService.albumUpdate(id, album);
    }

    @RequestMapping(value = "/api/albums", method = RequestMethod.GET)
    public Iterable<Album> getAlbums() {
        return albumService.getAlbum();
    }

    @RequestMapping(value = "/api/albums", method = RequestMethod.DELETE)
    public void deleteAlbum(@PathVariable(value = "id")Long id) {
        albumService.deleteAlbum(id);
    }

    @RequestMapping(value = "/api/albums", method = RequestMethod.POST)
    public Album createAlbum(@RequestBody Album album) {
        return albumService.createAlbum(album);
    }

    @RequestMapping(value = "/api/albums/{id}", method = RequestMethod.GET)
    public Optional<Album> findAlbum(@PathVariable(value = "id")Long id) {
        return albumService.findOneAlbum(id);
    }

}

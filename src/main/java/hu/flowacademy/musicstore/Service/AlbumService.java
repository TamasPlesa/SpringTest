package hu.flowacademy.musicstore.Service;

import hu.flowacademy.musicstore.Exception.ValidationException;
import hu.flowacademy.musicstore.Model.Album;
import hu.flowacademy.musicstore.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService {

    AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album albumUpdate (Long id, Album album) {
        Album newAlbum = albumRepository.findById(id).get();
        newAlbum.setCount(album.getCount());
        newAlbum.setTitle(album.getTitle());
        return albumRepository.save(newAlbum);
    }

    public Iterable<Album> getAlbum() {
        return albumRepository.findAll();
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    public Album createAlbum (Album album) {
    if(album.getTitle() == null && album.getCount() <= 0) {
        throw new ValidationException("Kötelező megadni");
    }
        return albumRepository.save(album);
    }

    public Optional<Album> findOneAlbum(Long id ) {
        return albumRepository.findById(id);
    }

}

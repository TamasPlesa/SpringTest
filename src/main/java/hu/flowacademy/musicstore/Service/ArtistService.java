package hu.flowacademy.musicstore.Service;

import hu.flowacademy.musicstore.Exception.ValidationException;
import hu.flowacademy.musicstore.Model.Album;
import hu.flowacademy.musicstore.Model.Artist;
import hu.flowacademy.musicstore.Repository.AlbumRepository;
import hu.flowacademy.musicstore.Repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistService {

    ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist artistUpdate (Long id, Artist artist) {
        Artist newArtist = artistRepository.findById(id).get();
        newArtist.setFirstname(artist.getFirstname());
        newArtist.setLastname(artist.getLastname());
        return artistRepository.save(newArtist);

    }

    public Iterable<Artist> getArtist() {
        return artistRepository.findAll();
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    public Artist createArtist (Artist artist) {
        if(artist.getFirstname() == null) {
            throw new ValidationException("Kötelező megadni");
        }
        if (artist.getLastname() == null) {
            throw new ValidationException("Kötelező megadni!");
        }
        return artistRepository.save(artist);
    }

    public Optional<Artist> findOneArtist(Long id ) {
        return artistRepository.findById(id);
    }


}

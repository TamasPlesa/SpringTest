package hu.flowacademy.musicstore.utils;

import hu.flowacademy.musicstore.Model.Album;
import hu.flowacademy.musicstore.Model.Artist;
import hu.flowacademy.musicstore.Repository.AlbumRepository;
import hu.flowacademy.musicstore.Repository.ArtistRepository;
import hu.flowacademy.musicstore.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class initDataLoader {

    // Bocsi :(


    AlbumRepository albumRepository;
    SongRepository songRepository;
    ArtistRepository artistRepository;

    @Autowired
    public initDataLoader(AlbumRepository albumRepository, SongRepository songRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @PostConstruct
    public void createItems() {
    Album firstAlbum = new Album(1L, "Heretic Anthem", 5L);
        Album secondAlbum = new Album(2L, "Better than ever", 6L);
        Album thirdAlbum = new Album(3L, "ThirdAlbum", 8L);
        albumRepository.save(firstAlbum);
        albumRepository.save(secondAlbum);
        albumRepository.save(thirdAlbum);

    }

    

}

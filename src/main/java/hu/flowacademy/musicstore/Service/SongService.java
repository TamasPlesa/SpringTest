package hu.flowacademy.musicstore.Service;

import hu.flowacademy.musicstore.Exception.ValidationException;
import hu.flowacademy.musicstore.Model.Artist;
import hu.flowacademy.musicstore.Model.Song;
import hu.flowacademy.musicstore.Repository.ArtistRepository;
import hu.flowacademy.musicstore.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SongService {

    SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song songUpdate (Long id, Song song) {
        Song newSong = songRepository.findById(id).get();
        newSong.setAlbum(song.getAlbum());
        newSong.setArtist(song.getArtist());
        newSong.setGenre(song.getGenre());
        newSong.setLength(song.getLength());
        newSong.setLyrics(song.getLyrics());
        newSong.setTitle(song.getTitle());
        newSong.setWriterName(song.getWriterName());
        newSong.setYear(song.getYear());
        return songRepository.save(newSong);



    }

    public Iterable<Song> getSong() {
        return songRepository.findAll();
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    public Song createSong (Song song) {
        if(song.getTitle() == null) {
            throw new ValidationException("Kötelező megadni");
        }
        if(song.getArtist() == null) {
            throw new ValidationException("Kötelező megadni");
        }
        if(song.getAlbum() == null) {
            throw new ValidationException("Kötelező megadni");
        }
        if(song.getGenre() == null) {
            throw new ValidationException("Kötelező megadni");
        }
        if(song.getLength() > 0) {
            throw new ValidationException("Kötelező megadni");
        }
        if(song.getYear() == null) {
            throw new ValidationException("Kötelező megadni");
        }
        if(song.getLyrics() == "") {
            return null;
        }
        if(song.getWriterName() == null) {
            throw new ValidationException("Kötelező megadni");
        }
        return songRepository.save(song);
    }

    public Optional<Song> findOneSong(Long id ) {
        return songRepository.findById(id);
    }

}

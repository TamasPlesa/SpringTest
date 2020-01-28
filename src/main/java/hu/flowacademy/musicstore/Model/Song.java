package hu.flowacademy.musicstore.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "songtable")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long length;

    private String lyrics;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate year;

    private String writerName;

    private Genre genre;

    @ManyToOne
    private Artist artist;

    @OneToOne
    private Album album;


    public Song() {
    }

    public Song(Long id, String title, Long length, String lyrics, LocalDate year, String writerName, Genre genre, Artist artist, Album album) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.lyrics = lyrics;
        this.year = year;
        this.writerName = writerName;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
    }

    public Long getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}

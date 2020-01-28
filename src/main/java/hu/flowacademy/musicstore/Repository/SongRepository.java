package hu.flowacademy.musicstore.Repository;

import hu.flowacademy.musicstore.Model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository <Song, Long> {
}

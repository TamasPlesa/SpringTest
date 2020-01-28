package hu.flowacademy.musicstore.Repository;

import hu.flowacademy.musicstore.Model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository <Artist, Long> {
}

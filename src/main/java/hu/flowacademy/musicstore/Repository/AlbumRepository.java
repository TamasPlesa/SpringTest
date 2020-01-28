package hu.flowacademy.musicstore.Repository;

import hu.flowacademy.musicstore.Model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository <Album, Long> {
}

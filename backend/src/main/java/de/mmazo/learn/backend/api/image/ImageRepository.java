package de.mmazo.learn.backend.api.image;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by mmazo on 14.05.17.
 */
public interface ImageRepository extends CrudRepository<Image, Long> {
}

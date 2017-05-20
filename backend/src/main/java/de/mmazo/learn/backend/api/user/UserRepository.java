package de.mmazo.learn.backend.api.user;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mmazo on 08.04.17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
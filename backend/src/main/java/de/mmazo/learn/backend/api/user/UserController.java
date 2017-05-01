package de.mmazo.learn.backend.api.user;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mmazo on 08.04.17.
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping()
    public List<User> getUserList() {
        return IteratorUtils.toList(this.userRepository.findAll().iterator());
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable(value="id") long id) {
        return this.userRepository.findOne(id);
    }

}

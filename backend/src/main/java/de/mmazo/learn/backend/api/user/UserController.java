package de.mmazo.learn.backend.api.user;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mmazo on 08.04.17.
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getUserList() {
        return IteratorUtils.toList(this.userRepository.findAll().iterator());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value="id") long id) {
        return this.userRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value="id") long id) {
        this.userRepository.delete(id);
    }

}

package de.mmazo.learn.backend.api.user;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Before
    public void setUp() throws Exception {
        User user1= new User();
        user1.setName("Presley");
        user1.setSurname("Elvis");
        user1.setUsername("elp");
        user1.setPassword("elp123!");
        this.userRepository.save(user1);
        assertNotNull(user1.getId());
    }

    @Test
    public void testFetchData(){
        Iterable<User> users = userRepository.findAll();
        int count = 0;
        for(User p : users){
            count++;
        }
        assertEquals(count, 1);
    }
}

package de.mmazo.learn.backend;

import de.mmazo.learn.backend.api.user.User;
import de.mmazo.learn.backend.api.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mmazo on 06.04.17.
 */
@SpringBootApplication
public class Backend {

    private static final Logger log = LoggerFactory.getLogger(Backend.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Backend.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            /*repository.save(new User("Mustermann",
                    "Max","mustermax","Mustermax123!"));
            repository.save(new User("Musterfrau",
                    "Maxi","mustermaxi","Mustermaxi123!"));*/

            // fetch all users
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

        };
    }

}

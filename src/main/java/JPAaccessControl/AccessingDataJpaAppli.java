package JPAaccessControl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication

public class AccessingDataJpaAppli {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaAppli.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaAppli.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a few users
            repository.save(new User("Jack", "1234p"));
            repository.save(new User("Chloe", "p99"));
            repository.save(new User("Kim", "0000"));
            log.info("");

            // user login access validation
            log.info("user login access validation");
            log.info("--------------------------------------------");
            Optional<User> optional =repository.findByLogin("Jack");
            boolean access=optional.isPresent();
            if(access){
                log.info("This user has access: "+optional.get().getLogin());
            }else{
                log.info("This user has not access: "+optional.toString());
            }
            System.out.println(access);



        };
    }
}

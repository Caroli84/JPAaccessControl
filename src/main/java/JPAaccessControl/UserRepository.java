package JPAaccessControl;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login); //tiene metodos ispresent() lo guardo en variable boolean

}

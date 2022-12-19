package exercise.repository;

//import exercise.model.User;
import exercise.model.User;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    // BEGIN
    Optional<User> findByUsername(String username);
    // END

    Optional<User> findByEmail(String email);
}

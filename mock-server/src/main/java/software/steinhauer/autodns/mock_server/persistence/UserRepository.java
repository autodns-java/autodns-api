package software.steinhauer.autodns.mock_server.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import software.steinhauer.autodns.mock_server.persistence.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsernameAndPasswordAndContext(String user, String password, String context);
}

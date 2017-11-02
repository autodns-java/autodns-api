package software.steinhauer.autodns.mock_server.persistence;

import org.springframework.stereotype.Service;
import software.steinhauer.autodns.mock_server.persistence.model.User;
import software.steinhauer.autodns.xml.request.model.Auth;

import javax.inject.Inject;

@Service
public class UserService {

	@Inject
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public User checkAuth(Auth auth) {
		return repository.findByUsernameAndPasswordAndContext(
				auth.getUser(),
				auth.getPassword(),
				auth.getContext());
	}
}

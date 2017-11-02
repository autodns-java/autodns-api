package software.steinhauer.autodns.mock_server.persistence;

import org.springframework.stereotype.Service;
import software.steinhauer.autodns.mock_server.persistence.model.Handle;

import javax.inject.Inject;
import java.util.List;

@Service
public class HandleService {

	@Inject
	private final HandleRepository repository;

	public HandleService(HandleRepository repository) {
		this.repository = repository;
	}

	public Handle save(Handle handle) {
		return repository.save(handle);
	}

	public List<Handle> getAll() {
		return repository.findAll();
	}
}

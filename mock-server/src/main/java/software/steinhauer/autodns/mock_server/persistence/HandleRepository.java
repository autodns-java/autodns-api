package software.steinhauer.autodns.mock_server.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.steinhauer.autodns.mock_server.persistence.model.Handle;

@Repository
public interface HandleRepository extends JpaRepository<Handle, Integer> {
}

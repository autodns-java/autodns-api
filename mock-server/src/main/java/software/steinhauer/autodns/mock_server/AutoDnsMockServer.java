package software.steinhauer.autodns.mock_server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan(basePackages = {"software.steinhauer.autodns.mock_server.persistence"})
public class AutoDnsMockServer {

	public static void main(String... args) {
		SpringApplication.run(AutoDnsMockServer.class, args);
	}
}

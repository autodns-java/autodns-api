package software.steinhauer.autodns.mock_server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoDnsMockServer {

	public static void main(String... args) {
		SpringApplication.run(AutoDnsMockServer.class, args);
	}
}

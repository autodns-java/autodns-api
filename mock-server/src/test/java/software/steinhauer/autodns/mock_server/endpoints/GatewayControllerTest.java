package software.steinhauer.autodns.mock_server.endpoints;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import software.steinhauer.autodns.xml.request.model.Auth;
import software.steinhauer.autodns.xml.request.model.Request;

public class GatewayControllerTest {

	private final GatewayController controller = new GatewayController();
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shouldThrowExceptionIfAuthIsMissingInRequest() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("No auth provided");

		controller.gatewayEndpoint(Request.builder().build());
	}

	@Test
	public void shouldThrowExceptionIfAuthHasNoUser() {
		checkAuthDetailExceptions(null,
				"password",
				"context",
				"No user given");
	}

	@Test
	public void shouldThrowExceptionIfAuthHasNoPassword() {
		checkAuthDetailExceptions("username",
				null,
				"context",
				"No password given");
	}

	@Test
	public void shouldThrowExceptionIfAuthHasNoContext() {
		checkAuthDetailExceptions("username",
				"password",
				null,
				"No context given");
	}

	private void checkAuthDetailExceptions(final String username,
	                                       final String password,
	                                       final String context,
	                                       final String expectedMessage) {

		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(expectedMessage);

		Auth auth = Auth.builder()
				.user(username)
				.password(password)
				.context(context)
				.build();

		Request request = Request.builder()
				.auth(auth)
				.build();

		controller.gatewayEndpoint(request);
	}


}
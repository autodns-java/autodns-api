package software.steinhauer.autodns.xml.adapter;

import org.junit.Test;
import software.steinhauer.autodns.xml.request.model.contact.HandleVerification;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HandleVerificationAdapterTest {

	private HandleVerificationAdapter adapter = new HandleVerificationAdapter();

	@Test
	public void shouldReturnSuccessGivenSUCCESS() {
		String actualResult = adapter.marshal(HandleVerification.SUCCESS);

		assertThat(actualResult, is(HandleVerification.SUCCESS.getValue()));
	}

	@Test
	public void shouldReturnDashGivenNull() {
		String actualResult = adapter.marshal(null);

		assertThat(actualResult, is("-"));
	}

	@Test
	public void shouldReturnSUCCESSGivenStringSuccess() {
		HandleVerification actualResult =
				adapter.unmarshal(HandleVerification.SUCCESS.getValue());

		assertThat(actualResult, is(HandleVerification.SUCCESS));
	}

	@Test
	public void shouldBeCaseInsensitive() {
		HandleVerification actualResult = adapter.unmarshal("pEnDiNg");

		assertThat(actualResult, is(HandleVerification.PENDING));
	}

	@Test
	public void shouldReturnUnknownForNull() {
		HandleVerification actualResult = adapter.unmarshal(null);

		assertThat(actualResult, is(HandleVerification.UNKNOWN));
	}

	@Test
	public void shouldReturnUnknownForDash() {
		HandleVerification actualResult = adapter.unmarshal("-");

		assertThat(actualResult, is(HandleVerification.UNKNOWN));
	}

	@Test
	public void shouldReturnUnknownForEmptyString() {
		HandleVerification actualResult = adapter.unmarshal("");

		assertThat(actualResult, is(HandleVerification.UNKNOWN));
	}

	@Test
	public void shouldReturnUnknownForStringWithSpacesOnly() {
		HandleVerification actualResult = adapter.unmarshal("     ");

		assertThat(actualResult, is(HandleVerification.UNKNOWN));
	}

	@Test
	public void shouldReturnUnknownForRandomString() {
		HandleVerification actualResult =
				adapter.unmarshal(UUID.randomUUID().toString());

		assertThat(actualResult, is(HandleVerification.UNKNOWN));
	}
}
package software.steinhauer.autodns.mock_server.processing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import software.steinhauer.autodns.xml.request.model.Auth;
import software.steinhauer.autodns.xml.request.model.Request;
import software.steinhauer.autodns.xml.request.model.RequestCode;
import software.steinhauer.autodns.xml.request.model.Task;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RequestProcessorFactoryTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shouldReturnHandleListRequestProcessorGivenValidRequest() {
		Auth auth = Auth.builder()
				.user("bigbird")
				.password("elmo")
				.context("42")
				.build();

		Task task = Task.builder()
				.code(RequestCode.CONTACT_LIST)
				.build();

		Request request = Request.builder()
				.auth(auth)
				.task(task)
				.build();

		RequestProcessor actualResult = RequestProcessorFactory.getProcessor(request);

		assertThat(actualResult, is(not(nullValue())));
		assertThat(actualResult, is(instanceOf(ContactListRequestProcessor.class)));
	}

	@Test
	public void shouldThrowExceptionGivenNullRequest() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Request can not be analysed if it's null.");

		RequestProcessorFactory.getProcessor(null);
	}

	@Test
	public void shouldThrowExceptionGivenNoTaskRequest() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("No task found.");

		Request request = Request.builder().build();

		RequestProcessorFactory.getProcessor(request);
	}

	@Test
	public void shouldThrowExceptionGivenNoRequestCodeInTask() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Invalid task, no code given.");

		Request request = Request.builder()
				.task(Task.builder().build())
				.build();
		RequestProcessorFactory.getProcessor(request);
	}

}
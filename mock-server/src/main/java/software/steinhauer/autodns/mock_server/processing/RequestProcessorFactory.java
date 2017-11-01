package software.steinhauer.autodns.mock_server.processing;

import org.springframework.util.Assert;
import software.steinhauer.autodns.xml.request.model.Request;


public class RequestProcessorFactory {

	public static RequestProcessor getProcessor(Request request) {
		Assert.notNull(request, "Request can not be analysed if it's null.");
		Assert.notNull(request.getTask(), "No task found.");
		Assert.notNull(request.getTask().getCode(), "Invalid task, no code given.");

		switch (request.getTask().getCode()) {
			case CONTACT_LIST:
				return new ContactListRequestProcessor(request);
			default:
				throw new IllegalArgumentException("Could not find a processor for given request.");
		}
	}

}

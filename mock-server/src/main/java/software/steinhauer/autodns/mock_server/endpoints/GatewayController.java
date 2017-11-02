package software.steinhauer.autodns.mock_server.endpoints;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import software.steinhauer.autodns.mock_server.processing.RequestProcessor;
import software.steinhauer.autodns.mock_server.processing.RequestProcessorFactory;
import software.steinhauer.autodns.xml.request.model.Request;
import software.steinhauer.autodns.xml.response.model.Response;

import javax.inject.Inject;

@Slf4j
@Controller
public class GatewayController {

	@Inject
	private ApplicationContext applicationContext;

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(name = "/gateway/", produces = "application/xml")
	@ResponseBody
	public Response gatewayEndpoint(@RequestBody Request request) {
		authenticate(request);

		RequestProcessor processor = RequestProcessorFactory.getProcessor(request, applicationContext);

		return processor.process();
	}

	// FIXME Actually check something
	// TODO move into separate class
	private void authenticate(Request request) {
		Assert.notNull(request.getAuth(), "No auth provided");
		Assert.hasLength(request.getAuth().getContext(), "No context given");
		Assert.hasLength(request.getAuth().getUser(), "No user given");
		Assert.hasLength(request.getAuth().getPassword(), "No password given");

	}
}

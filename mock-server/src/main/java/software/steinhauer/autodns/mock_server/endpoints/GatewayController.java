package software.steinhauer.autodns.mock_server.endpoints;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@Controller
public class GatewayController {


	@ResponseStatus(HttpStatus.OK)
	@PostMapping(name = "/gateway/", produces = "application/xml")
	@ResponseBody
	public String gatewayEndpoint(@RequestBody String body) {
		LOG.info(body);

		return "Gotcha";
	}
}

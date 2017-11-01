package software.steinhauer.autodns.examples.contacts;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import software.steinhauer.autodns.AutoDnsClient;
import software.steinhauer.autodns.resources.HandleResource;
import software.steinhauer.autodns.xml.request.model.contact.Handle;

import java.util.List;

@Slf4j
public class ListContactHandles {

	public static void main(String... args) throws Exception {
		AutoDnsClient client = AutoDnsClient.instance();

		HandleResource resource = new HandleResource(client);
		List<Handle> handleList = resource.getHandleList();

		handleList.forEach(handle -> LOG.info(new JSONObject(handle.toString()).toString(2)));
	}

}

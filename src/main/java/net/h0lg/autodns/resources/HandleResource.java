package net.h0lg.autodns.resources;

import net.h0lg.autodns.AutoDnsClient;
import net.h0lg.autodns.xml.builder.HandleListRequestBuilder;
import net.h0lg.autodns.xml.request.model.Request;
import net.h0lg.autodns.xml.request.model.contact.Handle;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HandleResource extends AbstractResource {

	private final AutoDnsClient client;

	public HandleResource(AutoDnsClient client) {
		this.client = client;
	}

	public List<Handle> getHandleList() throws IOException, JAXBException {
		Request request = new HandleListRequestBuilder(client.getCredentials()).build();

		// request email as additional attribute in result set
		request.getTask().setKeys(Arrays.asList("email", "created", "verification", "sip", "updater"));

		String requestXml = marshal(request);

		// FIXME use logging, stupid
		System.err.println(requestXml);

		// TODO should be handled elsewhere...
		OkHttpClient httpClient = new OkHttpClient();
		RequestBody requestBody = RequestBody.create(MediaType.parse("text/xml"), requestXml);

		okhttp3.Request httpRequest = new okhttp3.Request.Builder()
				.url("https://demo.autodns.com/gateway/")
				.post(requestBody)
				.build();

		Response response = httpClient.newCall(httpRequest).execute();

		String responseBody = response.body().string();
		net.h0lg.autodns.xml.response.model.Response autoDnsResponse = unmarshal(responseBody);

		return autoDnsResponse.getResult().get(0).getDataList().get(0).getHandles();
	}


}

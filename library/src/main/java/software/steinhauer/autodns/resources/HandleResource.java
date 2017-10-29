/*
 * MIT License
 *
 * Copyright (c) 2017 Holger Steinhauer <holger@steinhauer.software>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package software.steinhauer.autodns.resources;

import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import software.steinhauer.autodns.AutoDnsClient;
import software.steinhauer.autodns.xml.builder.HandleCreateRequestBuilder;
import software.steinhauer.autodns.xml.builder.HandleListRequestBuilder;
import software.steinhauer.autodns.xml.request.model.Request;
import software.steinhauer.autodns.xml.request.model.contact.Handle;
import software.steinhauer.autodns.xml.response.model.Response;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class HandleResource extends AbstractResource {

	private final AutoDnsClient client;

	public HandleResource(AutoDnsClient client) {
		this.client = client;
	}

	// FIXME
	public List<Handle> getHandleList() throws IOException, JAXBException {
		Request request = new HandleListRequestBuilder(client.getCredentials()).build();

		// request email as additional attribute in result set
		request.getTask().setKeys(Arrays.asList("email", "created", "verification", "sip", "updater"));


		// TODO should be handled elsewhere...
		Response autoDnsResponse = executeRequest(request);

		return autoDnsResponse.getResult().get(0).getDataList().get(0).getHandles();
	}

	public long createHandle(Handle newHandle) throws IOException, JAXBException {
		Request request = new HandleCreateRequestBuilder(client.getCredentials())
				.setHandle(newHandle)
				.build();

		return executeRequest(request).getResult().get(0).getStatus().getObject().getValueAsLong();
	}

	private Response executeRequest(Request request) throws IOException, JAXBException {
		String requestXml = marshal(request);
		LOG.trace(requestXml);

		OkHttpClient httpClient = new OkHttpClient();
		RequestBody requestBody = RequestBody.create(MediaType.parse("text/xml"), requestXml);

		okhttp3.Request httpRequest = new okhttp3.Request.Builder()
				// FIXME must come from properties!
				.url("https://demo.autodns.com/gateway/")
				.post(requestBody)
				.build();

		okhttp3.Response response = httpClient.newCall(httpRequest).execute();

		String responseBody = response.body().string();
		return unmarshal(responseBody);
	}

}

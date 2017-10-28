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

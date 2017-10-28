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

package demo;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import software.steinhauer.autodns.xml.builder.HandleListRequestBuilder;
import software.steinhauer.autodns.xml.request.model.Auth;
import software.steinhauer.autodns.xml.request.model.Request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

public class OkHttpTests {

	private static final String PASSWORD = "domain";
	private static final String CONTEXT = "1";
	private static final String AUTODNS_DEMO_HOST = "https://demo.autodns.com/gateway/";
	private Properties properties;

	@Test
	public void sendAContactListEnquiry() throws JAXBException, IOException {
		HandleListRequestBuilder listBuilder = new HandleListRequestBuilder(
				new Auth(getUsername(), getPassword(), getContext())
		);

		StringWriter messageBody = new StringWriter();

		JAXBContext context = JAXBContext.newInstance(Request.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(listBuilder.build(), messageBody);

		OkHttpClient client = new OkHttpClient();

		RequestBody body = RequestBody.create(MediaType.parse("text/xml"), messageBody.toString());

		System.err.println("Request: [" + messageBody.toString() + "]");

		okhttp3.Request httpRequest = new okhttp3.Request.Builder()
				.url(AUTODNS_DEMO_HOST)
				.post(body)
				.build();

		Response response = client.newCall(httpRequest).execute();

		System.out.println("Response: [" + response.body().string() + "]");

	}

	private Properties getProperties() throws IOException {
		if (this.properties == null) {
			this.properties = new Properties();
			this.properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("autodns.properties"));
		}

		return this.properties;
	}

	private String getUsername() throws IOException {
		return getProperties().getProperty("autodns.username");
	}

	private String getPassword() throws IOException {
		return getProperties().getProperty("autodns.password");
	}

	private String getContext() throws IOException {
		return getProperties().getProperty("autodns.context");
	}
}

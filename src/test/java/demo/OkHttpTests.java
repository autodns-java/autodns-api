package demo;

import net.h0lg.autodns.xml.builder.HandleListRequestBuilder;
import net.h0lg.autodns.xml.request.model.Auth;
import net.h0lg.autodns.xml.request.model.Request;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;

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

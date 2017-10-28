package demo;

import com.neovisionaries.i18n.CountryCode;
import net.h0lg.autodns.xml.builder.HandleListRequestBuilder;
import net.h0lg.autodns.xml.request.model.Auth;
import net.h0lg.autodns.xml.request.model.Request;
import net.h0lg.autodns.xml.request.model.RequestCode;
import net.h0lg.autodns.xml.request.model.Task;
import net.h0lg.autodns.xml.request.model.contact.*;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Arrays;
import java.util.List;

public class HandleRequestCreationTest {

	private static final String USERNAME = "user";
	private static final String PASSWORD = "domain";
	private static final String CONTEXT = "1";

	@Test
	public void checkHandleRequestXml() throws JAXBException {

		Request request = new Request();

		Auth auth = new Auth(USERNAME, PASSWORD, CONTEXT);
		request.setAuth(auth);

		Task task = new Task(RequestCode.CONTACT_CREATE);
		request.setTask(task);

		List<String> threeLineAddress = Arrays.asList("Address line 1", "Address line 2", "Address line 3");

		Handle handle = Handle.builder()
				.type(HandleType.PERSON)
				.firstName("Testus")
				.lastName("McTestFace")
				.addresses(threeLineAddress)
				.postcode("123456")
				.city("Testland")
				.country(CountryCode.DE)
				.phone("+44-1234-5678901")
				.fax("+44-1234-5678901")
				.email("me@you.local")
				.protection(HandleProtection.LIMITED)
				.replyTo("me@there.local")
				.build();

		HandleExtension extension = new HandleExtension();
		extension.setExtensionMode(HandleExtensionMode.REPLACE);
		extension.setGender(HandleGender.MALE);

		handle.setExtension(extension);

		task.setHandle(handle);

		JAXBContext context = JAXBContext.newInstance(Request.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(request, System.out);
	}

	@Test
	public void testContactListEnquiryXml() throws JAXBException {
		HandleListRequestBuilder builder = new HandleListRequestBuilder(
				new Auth(USERNAME, PASSWORD, CONTEXT)
		);

		JAXBContext context = JAXBContext.newInstance(Request.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(builder.build(), System.out);
	}

}

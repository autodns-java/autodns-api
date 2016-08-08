package demo;

import com.neovisionaries.i18n.CountryCode;
import net.h0lg.autodns.xml.request.model.Auth;
import net.h0lg.autodns.xml.request.model.Request;
import net.h0lg.autodns.xml.request.model.RequestCode;
import net.h0lg.autodns.xml.request.model.Task;
import net.h0lg.autodns.xml.request.model.contact.*;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class HandleRequestCreationTest {

	@Test
	public void checkHandleRequestCXml() throws JAXBException {

		Request request = new Request();

		Auth auth = new Auth();
		auth.setUser("user");
		auth.setPassword("domain");
		auth.setContext("1");
		request.setAuth(auth);

		Task task = new Task();
		task.setCode(RequestCode.CONTACT_CREATE);
		request.setTask(task);

		Handle handle = new Handle();
		handle.setType(HandleType.PERSON);
		handle.setFirstName("Testus");
		handle.setLastName("McTestFace");
		handle.setOrganisation(null);
		handle.getAddresses().add("Address line 1");
		handle.getAddresses().add("Address line 2");
		handle.getAddresses().add("Address line 3");
		handle.setCity("Testland");
		handle.setPostcode("123456");
		handle.setCountry(CountryCode.DE);
		handle.setPhone("+44-1234-5678901");
		handle.setFax("+44-1234-5678901");
		handle.setEmail("me@you.local");
		handle.setProtection(HandleProtection.LIMITED);
		handle.getNicReferences().add(CountryCode.DE);
		handle.setReplyTo("me@you.local");

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

}

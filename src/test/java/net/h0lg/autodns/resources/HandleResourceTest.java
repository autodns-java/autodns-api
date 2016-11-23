package net.h0lg.autodns.resources;

import net.h0lg.autodns.AutoDnsClient;
import net.h0lg.autodns.xml.request.model.contact.Handle;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

public class HandleResourceTest {

	@Test
	public void simpleHandleEnquiry_should_returnList() throws IOException, JAXBException {
		AutoDnsClient client = AutoDnsClient.instance();

		HandleResource resource = new HandleResource(client);

		List<Handle> handleList = resource.getHandleList();

		assertThat(handleList, is(not(empty())));
	}

}
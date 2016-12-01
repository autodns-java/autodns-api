package net.h0lg.autodns.xml.builder;

import com.neovisionaries.i18n.CountryCode;
import net.h0lg.autodns.xml.request.model.contact.Handle;
import net.h0lg.autodns.xml.request.model.contact.HandleProtection;
import net.h0lg.autodns.xml.request.model.contact.HandleType;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HandleBuilderTest {

    @Test
    public void should_returnHandle_given_minimalData() {
        HandleBuilder createHandleBuilder = HandleBuilder.getCreateHandleBuilder();

        final String firstName = "Foo";
        final String lastName = "Bar";
		final String organisation = "private";
		final String postcode = "AB12 3CD";
		final String city = "Example City";
		final String replyTo = "me@you.local";

		Handle actualHandle = createHandleBuilder.setType(HandleType.PERSON)
				.setFirstName(firstName)
				.setLastName(lastName)
				.setOrganisation(organisation)
				.setAddresses(oneLineStreet())
				.setPostcode(postcode)
				.setCity(city)
				.setCountry(CountryCode.UK)
				.setProtection(HandleProtection.LIMITED)
				.setReplyTo(replyTo)
				.build();

		Handle expectedHandle = new Handle(null,
				null,
				HandleType.PERSON,
				firstName,
				lastName,
				null,
				organisation,
				oneLineStreet(),
				postcode,
				city,
				null,
				CountryCode.UK,
				null,
				null,
				null,
				HandleProtection.LIMITED,
				null,
				null,
				replyTo,
				null,
				null,
				null);

		assertThat(actualHandle, is(expectedHandle));

	}

	private List<String> oneLineStreet() {
		return Collections.singletonList("123 Example Street");
	}


}

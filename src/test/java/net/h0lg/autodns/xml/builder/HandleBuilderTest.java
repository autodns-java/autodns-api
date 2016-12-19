package net.h0lg.autodns.xml.builder;

import com.neovisionaries.i18n.CountryCode;
import net.h0lg.autodns.xml.request.model.Owner;
import net.h0lg.autodns.xml.request.model.contact.Handle;
import net.h0lg.autodns.xml.request.model.contact.HandleForceCreate;
import net.h0lg.autodns.xml.request.model.contact.HandleProtection;
import net.h0lg.autodns.xml.request.model.contact.HandleType;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HandleBuilderTest {

	private final String id = "abc123";
	private final String alias = "testAlias";
	private final String title = "Prof. Dr. Dr.";
	private final String firstName = "Foo";
	private final String lastName = "Bar";
	private final String organisation = "private";
	private final String postcode = "AB12 3CD";
	private final String city = "Example City";
	private final String replyTo = "me@you.local";
	private final String state = "Sample State";
	private final String phone = "+44 1234 567890";
	private final String fax = "+44 9876 543210";
	private final String email = "foo@bar.local";
	private final List<CountryCode> nicReference = Collections.singletonList(CountryCode.DE);
	private final String remarks = "Test Remark";
	private final String comment = "Test comment";
	private final Owner owner = new Owner();

	@Test
    public void should_returnHandle_given_minimalData() {
        HandleBuilder builder = new HandleBuilder();

		Handle actualHandle = createBasicHandleBuilder().build();

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

	@Test
	public void should_returnHandle_givenAllDetails() {
		HandleBuilder builder = createBasicHandleBuilder();

		builder.setId(id)
				.setAlias(alias)
				.setType(HandleType.ORG)
				.setTitle(title)
				.setState(state)
				.setCountry(CountryCode.DE)
				.setPhone(phone)
				.setFax(fax)
				.setEmail(email)
				.setProtection(HandleProtection.ALL)
				.setNicReferences(nicReference)
				.setRemarks(remarks)
				.setForceHandleCreate(HandleForceCreate.FORCE)
				.setComment(comment)
				.setOwner(owner);


		Handle expectedHandle = new Handle(id,
				alias,
				HandleType.ORG,
				firstName,
				lastName,
				title,
				organisation,
				oneLineStreet(),
				postcode,
				city,
				state,
				CountryCode.DE,
				phone,
				fax,
				email,
				HandleProtection.ALL,
				nicReference,
				remarks,
				replyTo,
				HandleForceCreate.FORCE,
				comment,
				owner);

		assertThat(builder.build(), is(expectedHandle));

	}

	private HandleBuilder createBasicHandleBuilder() {
		HandleBuilder builder = new HandleBuilder();

		return builder.setType(HandleType.PERSON)
				.setFirstName(firstName)
				.setLastName(lastName)
				.setOrganisation(organisation)
				.setAddresses(oneLineStreet())
				.setPostcode(postcode)
				.setCity(city)
				.setCountry(CountryCode.UK)
				.setProtection(HandleProtection.LIMITED)
				.setReplyTo(replyTo);
	}

	private List<String> oneLineStreet() {
		return Collections.singletonList("123 Example Street");
	}


}

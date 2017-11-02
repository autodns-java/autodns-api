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

package software.steinhauer.autodns.xml.builder;

import com.neovisionaries.i18n.CountryCode;
import org.junit.Test;
import software.steinhauer.autodns.xml.request.model.NicReference;
import software.steinhauer.autodns.xml.request.model.Owner;
import software.steinhauer.autodns.xml.request.model.contact.Handle;
import software.steinhauer.autodns.xml.request.model.contact.HandleForceCreate;
import software.steinhauer.autodns.xml.request.model.contact.HandleProtection;
import software.steinhauer.autodns.xml.request.model.contact.HandleType;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
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
	private final List<NicReference> nicReference = Collections.singletonList(NicReference.DE);
	private final String remarks = "Test Remark";
	private final String comment = "Test comment";
	private final Owner owner = new Owner();

	@Test
	public void should_returnHandle_given_minimalData() {
		Handle actualHandle = createBasicHandleBuilder().build();

		Handle expectedHandle = Handle.builder()
				.type(HandleType.PERSON)
				.firstName(firstName)
				.lastName(lastName)
				.organisation(organisation)
				.addresses(oneLineStreet())
				.postcode(postcode)
				.city(city)
				.country(CountryCode.UK)
				.protection(HandleProtection.LIMITED)
				.replyTo(replyTo)
				.build();

		assertThat(actualHandle, is(expectedHandle));
	}

	@Test
	public void should_returnHandle_givenAllDetails() {
		Handle.HandleBuilder builder = createBasicHandleBuilder();

		builder
				.id(id)
				.alias(alias)
				.type(HandleType.ORG)
				.title(title)
				.state(state)
				.country(CountryCode.DE)
				.phone(phone)
				.fax(fax)
				.email(email)
				.protection(HandleProtection.ALL)
				.nicReferences(nicReference)
				.remarks(remarks)
				.forceHandleCreate(HandleForceCreate.FORCE)
				.comment(comment)
				.owner(owner);


		Handle expectedHandle = Handle.builder()
				.id(id)
				.alias(alias)
				.type(HandleType.ORG)
				.firstName(firstName)
				.lastName(lastName)
				.title(title)
				.organisation(organisation)
				.addresses(oneLineStreet())
				.postcode(postcode)
				.city(city)
				.state(state)
				.country(CountryCode.DE)
				.phone(phone)
				.fax(fax)
				.email(email)
				.protection(HandleProtection.ALL)
				.nicReferences(nicReference)
				.remarks(remarks)
				.replyTo(replyTo)
				.forceHandleCreate(HandleForceCreate.FORCE)
				.comment(comment)
				.owner(owner)
				.build();

		assertThat(builder.build(), is(expectedHandle));

	}

	private Handle.HandleBuilder createBasicHandleBuilder() {
		return Handle.builder()
				.type(HandleType.PERSON)
				.firstName(firstName)
				.lastName(lastName)
				.organisation(organisation)
				.addresses(oneLineStreet())
				.postcode(postcode)
				.city(city)
				.country(CountryCode.UK)
				.protection(HandleProtection.LIMITED)
				.replyTo(replyTo);
	}

	private List<String> oneLineStreet() {
		return Collections.singletonList("123 Example Street");
	}


}

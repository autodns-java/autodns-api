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
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class RequestBuilderTest {

	private final String firstName = "Testus";
	private final String lastName = "Test";
	private final String organisation = "Test Ltd";
	private final List<String> streets = Collections.singletonList("Test Street 123");
	private final String postcode = "AB12 3CD";
	private final CountryCode country = CountryCode.UK;
	private final String phoneNumber = "0044 1234 123456";
	private final String faxNumber = "0044 1234 123457";
	private final String email = "test@testus.local";
	private final String sip = "ab.cd.ef.gh";
	private final String reply = "test+reply@testus.local";
	private final String comment = "Testus Is Testing";

	@Test
	@Ignore
	public void testCreateHandle() {
//		Task actualTask = RequestBuilder.createHandle()
//				.forPerson()
//				.withName(firstName, lastName)
//				.worksFor(organisation)
//				.livesAt(streets, postcode, country)
//				.withPhoneNumber(phoneNumber)
//				.withFaxNumber(faxNumber)
//				.withEmailAddress(email)
//				.withSipNumber(sip)
//				.expectsReplyTo(reply)
//				.wantsDataProtected()
//				.comment(comment)
//				.build();

//		assertThat(actualTask, is(not(nullValue())));
	}

}

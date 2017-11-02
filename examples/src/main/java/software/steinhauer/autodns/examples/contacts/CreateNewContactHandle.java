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

package software.steinhauer.autodns.examples.contacts;

import com.neovisionaries.i18n.CountryCode;
import software.steinhauer.autodns.AutoDnsClient;
import software.steinhauer.autodns.resources.HandleResource;
import software.steinhauer.autodns.xml.request.model.NicReference;
import software.steinhauer.autodns.xml.request.model.contact.Handle;
import software.steinhauer.autodns.xml.request.model.contact.HandleProtection;
import software.steinhauer.autodns.xml.request.model.contact.HandleType;

import java.util.Collections;

public class CreateNewContactHandle {

	public static void main(String... arg) throws Exception {
		AutoDnsClient client = AutoDnsClient.instance();

		Handle handle = Handle.builder()
				.type(HandleType.PERSON)
				.firstName("Big")
				.lastName("Bird")
				.organisation("Sesamestreet Inc")
				.addresses(Collections.singletonList("Sesamestreet 1"))
				.postcode("12345")
				.city("SesameCity")
				.country(CountryCode.US)
				.phone("+1-12345-12345")
				.fax("+1-12345-12345")
				.email("big@bird.local")
				.protection(HandleProtection.LIMITED)
				.nicReferences(Collections.singletonList(NicReference.DE))
				.replyTo("big@bird.local")
				.build();

		HandleResource resource = new HandleResource(client);
		long newId = resource.createHandle(handle);

		System.out.println("You created a new contact. The handle's ID is: #" + newId);
	}

}

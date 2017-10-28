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

import net.h0lg.autodns.xml.response.model.Response;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UnmarshallerTest {

	private static final String SUCCESSFUL_RESPONSE = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
			"<response>\n" +
			"  <result>\n" +
			"    <data>\n" +
			"      <handle>\n" +
			"        <alias>Testus-Test</alias>\n" +
			"        <fname>Testus</fname>\n" +
			"        <id>31243072</id>\n" +
			"        <lname>Test</lname>\n" +
			"        <organization></organization>\n" +
			"        <owner>\n" +
			"          <context>1</context>\n" +
			"          <user>user</user>\n" +
			"        </owner>\n" +
			"        <type>PERSON</type>\n" +
			"      </handle>\n" +
			"      <summary>1</summary>\n" +
			"    </data>\n" +
			"    <status>\n" +
			"      <code>S0304</code>\n" +
			"      <text>Domainkontakt-Daten wurden erfolgreich ermittelt.</text>\n" +
			"      <type>success</type>\n" +
			"    </status>\n" +
			"  </result>\n" +
			"</response>\n";

	@Test
	public void unmarshaller_should_returnValidResponseObjectWithOneHandle_given_validAndSuccessfulResponseXml() throws JAXBException {
		System.setProperty("jaxb.debug", "true");

		JAXBContext context = JAXBContext.newInstance(Response.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setEventHandler(new DefaultValidationEventHandler());

		StringReader responseInReader = new StringReader(SUCCESSFUL_RESPONSE);
		Response actualResult = (Response) unmarshaller.unmarshal(responseInReader);

		assertThat(actualResult, is(not(nullValue())));
		assertThat(actualResult.getResult(), is(not(nullValue())));
	}
}

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

import org.junit.Test;
import software.steinhauer.autodns.xml.request.model.Auth;
import software.steinhauer.autodns.xml.request.model.Request;
import software.steinhauer.autodns.xml.request.model.RequestCode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class HandleListRequestBuilderTest {

	private static final String USERNAME = "user";
	private static final String PASSWORD = "dummy";
	private static final String CONTEXT = "1";


	@Test
	public void should_returnValidRequest_given_authenticationInformation() {
		HandleListRequestBuilder builder = new HandleListRequestBuilder(
				new Auth(USERNAME, PASSWORD, CONTEXT)
		);

		Request actualValue = builder.build();

		assertThat(actualValue, is(notNullValue()));
		assertThat(actualValue.getAuth(), is(notNullValue()));
		assertThat(actualValue.getTask().getCode(), is(RequestCode.CONTACT_LIST));
		assertThat(actualValue.getTask().getView(), is(nullValue()));
	}

}

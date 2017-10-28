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

package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.model.contact.HandleProtection;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class HandleProtectionAdapterTest {

	private final HandleProtectionAdapter adapter = new HandleProtectionAdapter();

	@Test
	public void unmarshal_should_returnLimited() throws Exception {
		String given = "b";

		HandleProtection actualResult = adapter.unmarshal(given);
		assertThat(actualResult, is(HandleProtection.LIMITED));
	}

	@Test
	public void unmarshal_should_returnAll() throws Exception {
		String given = "a";

		HandleProtection actualResult = adapter.unmarshal(given);
		assertThat(actualResult, is(HandleProtection.ALL));
	}

	@Test
	public void unmarshal_should_returnNull_given_randomString() throws Exception {
		HandleProtection actualResult = adapter.unmarshal(adapter.toString());

		assertThat(actualResult, is(nullValue()));
	}

	@Test
	public void unmarshal_should_returnNull_given_null() throws Exception {
		HandleProtection actualResult = adapter.unmarshal(null);

		assertThat(actualResult, is(nullValue()));
	}

	@Test
	public void unmarshal_should_beCaseInsensitive() throws Exception {
		String given = "A";

		HandleProtection actualResult = adapter.unmarshal(given);

		assertThat(actualResult, is(HandleProtection.ALL));
	}

	@Test
	public void marshal_should_returnA_given_All() throws Exception {
		String actualResult = adapter.marshal(HandleProtection.ALL);

		assertThat(actualResult, is(HandleProtection.ALL.getValue()));
	}

	@Test
	public void marshal_should_returnB_given_Limited() throws Exception {
		String actualResult = adapter.marshal(HandleProtection.LIMITED);

		assertThat(actualResult, is(HandleProtection.LIMITED.getValue()));
	}

	@Test
	public void marshal_should_beNullSafe() throws Exception {
		String actualResult = adapter.marshal(null);

		assertThat(actualResult, is(nullValue()));
	}
}
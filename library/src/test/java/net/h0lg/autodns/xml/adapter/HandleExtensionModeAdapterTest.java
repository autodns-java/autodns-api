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

import net.h0lg.autodns.xml.request.model.contact.HandleExtensionMode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class HandleExtensionModeAdapterTest {

	private HandleExtensionModeAdapter adapter = new HandleExtensionModeAdapter();

	@Test
	public void unmarshal_should_returnMerge_given_merge() throws Exception {
		String given = "merge";

		HandleExtensionMode actualResult = adapter.unmarshal(given);

		assertThat(actualResult, is(HandleExtensionMode.MERGE));
	}

	@Test
	public void unmarshal_should_returnReplace_given_replace() throws Exception {
		String given = "replace";

		HandleExtensionMode actualResult = adapter.unmarshal(given);

		assertThat(actualResult, is(HandleExtensionMode.REPLACE));
	}

	@Test
	public void unmarshal_should_beCaseInsensitive() throws Exception {
		String given = "MeRgE";

		HandleExtensionMode actualResult = adapter.unmarshal(given);

		assertThat(actualResult, is(HandleExtensionMode.MERGE));
	}

	@Test
	public void unmarshal_should_beNullSafe() throws Exception {
		HandleExtensionMode actualResult = adapter.unmarshal(null);

		assertThat(actualResult, is(nullValue()));
	}

	@Test
	public void unmarshal_should_returnNull_given_randomValue() throws Exception {
		HandleExtensionMode actualResult = adapter.unmarshal(adapter.toString());

		assertThat(actualResult, is(nullValue()));
	}

	@Test
	public void marshal_should_returnMerge() throws Exception {
		String actualResult = adapter.marshal(HandleExtensionMode.MERGE);

		assertThat(actualResult, is(HandleExtensionMode.MERGE.getValue()));
	}

	@Test
	public void marshal_should_returnReplace() throws Exception {
		String actualResult = adapter.marshal(HandleExtensionMode.REPLACE);

		assertThat(actualResult, is(HandleExtensionMode.REPLACE.getValue()));
	}

	@Test
	public void marshal_should_returnNull_given_null() throws Exception {
		String actualResult = adapter.marshal(null);

		assertThat(actualResult, is(nullValue()));
	}
}
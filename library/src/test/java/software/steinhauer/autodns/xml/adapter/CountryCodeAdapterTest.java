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

package software.steinhauer.autodns.xml.adapter;

import com.neovisionaries.i18n.CountryCode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountryCodeAdapterTest {

	private final CountryCodeAdapter countryCodeAdapter = new CountryCodeAdapter();

	@Test
	public void unmarshal_should_returnGermanyCode_given_DE() {
		String input = "DE";

		CountryCode actualCode = countryCodeAdapter.unmarshal(input);

		assertThat(actualCode, is(CountryCode.DE));
	}

	@Test
	public void unmarshal_should_returnGermanyCode_given_lowerCaseDE() {
		String input = "de";

		CountryCode actualCode = countryCodeAdapter.unmarshal(input);

		assertThat(actualCode, is(CountryCode.DE));
	}

	@Test
	public void unmarshal_should_returnUndefinedCountryCode_given_null() {
		CountryCode actualCode = countryCodeAdapter.unmarshal(null);

		assertThat(actualCode, is(CountryCode.UNDEFINED));
	}

	@Test
	public void marshal_should_returnDe_given_GermanCountryCode() {
		CountryCode given = CountryCode.DE;

		String actualResult = countryCodeAdapter.marshal(given);

		assertThat(actualResult, is(given.getAlpha2()));
	}

	@Test
	public void marshal_should_returnUndefined_given_null() {
		String actualResult = countryCodeAdapter.marshal(null);

		assertThat(actualResult, is(CountryCode.UNDEFINED.getAlpha2()));
	}


}
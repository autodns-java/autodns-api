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

import com.neovisionaries.i18n.CountryCode;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;

public class CountryCodeAdapter extends XmlAdapter<String, CountryCode> {

	@Override
	public CountryCode unmarshal(String value) throws Exception {
		return Arrays.stream(CountryCode.values())
				.filter(cc -> cc.getAlpha2().equalsIgnoreCase(value))
				.findFirst()
				.orElse(CountryCode.UNDEFINED);

	}

	@Override
	public String marshal(CountryCode country) throws Exception {
		if (country == null) {
			return CountryCode.UNDEFINED.getAlpha2();
		}

		return country.getAlpha2();
	}
}

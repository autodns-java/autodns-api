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

import software.steinhauer.autodns.xml.request.model.contact.HandleExtensionMode;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;

public class HandleExtensionModeAdapter extends XmlAdapter<String, HandleExtensionMode> {
	@Override
	public HandleExtensionMode unmarshal(String s) {
		return Arrays.stream(HandleExtensionMode.values())
				.filter(hem -> hem.getValue().equalsIgnoreCase(s))
				.findFirst()
				.orElse(null);
	}

	@Override
	public String marshal(HandleExtensionMode mode) {
		if (mode == null) {
			return null;
		}

		return mode.getValue();
	}
}

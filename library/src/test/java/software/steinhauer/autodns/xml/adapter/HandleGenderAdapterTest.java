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

import org.junit.Test;
import software.steinhauer.autodns.xml.request.model.contact.HandleGender;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HandleGenderAdapterTest {

	private final HandleGenderAdapter genderAdapter = new HandleGenderAdapter();

	@Test
	public void unmarshal_should_returnFemale_given_f() {
		String given = "f";

		HandleGender actualResult = genderAdapter.unmarshal(given);

		assertThat(actualResult, is(HandleGender.FEMALE));
	}

	@Test
	public void unmarshal_should_returnMale_given_m() {
		String given = "m";

		HandleGender actualResult = genderAdapter.unmarshal(given);

		assertThat(actualResult, is(HandleGender.MALE));
	}

	@Test
	public void unmarshal_should_returnUnknown_given_null() {
		HandleGender actualResult = genderAdapter.unmarshal(null);

		assertThat(actualResult, is(HandleGender.UNKNOWN));
	}

	@Test
	public void unmarshal_should_returnUnknown_given_emptyString() {
		HandleGender actualResult = genderAdapter.unmarshal("");

		assertThat(actualResult, is(HandleGender.UNKNOWN));
	}

	@Test
	public void unmarshal_should_returnUnknown_given_randomString() {
		HandleGender actualResult = genderAdapter.unmarshal(genderAdapter.toString());

		assertThat(actualResult, is(HandleGender.UNKNOWN));
	}

	@Test
	public void unmarshal_should_beCaseInsensitive() {
		String given = "F";

		HandleGender actualUpperCaseResult = genderAdapter.unmarshal(given.toUpperCase());
		HandleGender actualLowerCaseResult = genderAdapter.unmarshal(given.toLowerCase());

		assertThat(actualLowerCaseResult, is(actualUpperCaseResult));
	}

	@Test
	public void marshal_should_returnM_givenMale() {
		String actualResult = genderAdapter.marshal(HandleGender.MALE);

		assertThat(actualResult, is(HandleGender.MALE.getValue()));
	}

	@Test
	public void marshal_should_returnF_givenFemale() {
		String actualResult = genderAdapter.marshal(HandleGender.FEMALE);

		assertThat(actualResult, is(HandleGender.FEMALE.getValue()));
	}

	@Test
	public void marshal_should_returnUnknown_givenNull() {
		String actualResult = genderAdapter.marshal(null);

		assertThat(actualResult, is(HandleGender.UNKNOWN.getValue()));
	}
}
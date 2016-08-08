package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.model.contact.HandleGender;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HandleGenderAdapterTest {

	private final HandleGenderAdapter genderAdapter = new HandleGenderAdapter();

	@Test
	public void unmarshal_should_returnFemale_given_f() throws Exception {
		String given = "f";

		HandleGender actualResult = genderAdapter.unmarshal(given);

		assertThat(actualResult, is(HandleGender.FEMALE));
	}

	@Test
	public void unmarshal_should_returnMale_given_m() throws Exception {
		String given = "m";

		HandleGender actualResult = genderAdapter.unmarshal(given);

		assertThat(actualResult, is(HandleGender.MALE));
	}

	@Test
	public void unmarshal_should_returnUnknown_given_null() throws Exception {
		HandleGender actualResult = genderAdapter.unmarshal(null);

		assertThat(actualResult, is(HandleGender.UNKNOWN));
	}

	@Test
	public void unmarshal_should_returnUnknown_given_emptyString() throws Exception {
		HandleGender actualResult = genderAdapter.unmarshal("");

		assertThat(actualResult, is(HandleGender.UNKNOWN));
	}

	@Test
	public void unmarshal_should_returnUnknown_given_randomString() throws Exception {
		HandleGender actualResult = genderAdapter.unmarshal(genderAdapter.toString());

		assertThat(actualResult, is(HandleGender.UNKNOWN));
	}

	@Test
	public void unmarshal_should_beCaseInsensitive() throws Exception {
		String given = "F";

		HandleGender actualUpperCaseResult = genderAdapter.unmarshal(given.toUpperCase());
		HandleGender actualLowerCaseResult = genderAdapter.unmarshal(given.toLowerCase());

		assertThat(actualLowerCaseResult, is(actualUpperCaseResult));
	}

	@Test
	public void marshal_should_returnM_givenMale() throws Exception {
		String actualResult = genderAdapter.marshal(HandleGender.MALE);

		assertThat(actualResult, is(HandleGender.MALE.getValue()));
	}

	@Test
	public void marshal_should_returnF_givenFemale() throws Exception {
		String actualResult = genderAdapter.marshal(HandleGender.FEMALE);

		assertThat(actualResult, is(HandleGender.FEMALE.getValue()));;
	}

	@Test
	public void marshal_should_returnUnknown_givenNull() throws Exception {
		String actualResult = genderAdapter.marshal(null);

		assertThat(actualResult, is(HandleGender.UNKNOWN.getValue()));
	}
}
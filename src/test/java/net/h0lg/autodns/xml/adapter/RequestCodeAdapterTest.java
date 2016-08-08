package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.model.RequestCode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class RequestCodeAdapterTest {

	private final RequestCodeAdapter adapter = new RequestCodeAdapter();

	@Test
	public void unmarshal_should_returnContactCreate_given_0301() throws Exception {
		String given = "0301";

		RequestCode actualResult = adapter.unmarshal(given);

		assertThat(actualResult, is(RequestCode.CONTACT_CREATE));
	}

	@Test
	public void unmarshal_should_returnNull_given_invalidValue() throws Exception {
		String invalidValue = "301";

		RequestCode actualResult = adapter.unmarshal(invalidValue);

		assertThat(actualResult, is(nullValue()));
	}

	@Test
	public void unmarshal_should_beNullSafe() throws Exception {
		RequestCode actualResult = adapter.unmarshal(null);

		assertThat(actualResult, is(nullValue()));
	}

	@Test
	public void marshal_should_return0301_given_ContactCreate() throws Exception {
		String actualResult = adapter.marshal(RequestCode.CONTACT_CREATE);

		assertThat(actualResult, is(RequestCode.CONTACT_CREATE.getValue()));
	}

	@Test
	public void marshal_should_beNullSafe() throws Exception {
		String actualResult = adapter.marshal(null);

		assertThat(actualResult, is(nullValue()));
	}

}
package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.model.contact.HandleExtensionMode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

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
package net.h0lg.autodns.xml.adapter;

import com.neovisionaries.i18n.CountryCode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountryCodeAdapterTest {

	private final CountryCodeAdapter countryCodeAdapter = new CountryCodeAdapter();

	@Test
	public void unmarshal_should_returnGermanyCode_given_DE() throws Exception {
		String input = "DE";

		CountryCode actualCode = countryCodeAdapter.unmarshal(input);

		assertThat(actualCode, is(CountryCode.DE));
	}

	@Test
	public void unmarshal_should_returnGermanyCode_given_lowerCaseDE() throws Exception {
		String input = "de";

		CountryCode actualCode = countryCodeAdapter.unmarshal(input);

		assertThat(actualCode, is(CountryCode.DE));
	}

	@Test
	public void unmarshal_should_returnUndefinedCountryCode_given_null() throws Exception {
		CountryCode actualCode = countryCodeAdapter.unmarshal(null);

		assertThat(actualCode, is(CountryCode.UNDEFINED));
	}

	@Test
	public void marshal_should_returnDe_given_GermanCountryCode() throws Exception {
		CountryCode given = CountryCode.DE;

		String actualResult = countryCodeAdapter.marshal(given);

		assertThat(actualResult, is(given.getAlpha2()));
	}

	@Test
	public void marshal_should_returnUndefined_given_null() throws Exception {
		String actualResult = countryCodeAdapter.marshal(null);

		assertThat(actualResult, is(CountryCode.UNDEFINED.getAlpha2()));
	}


}
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

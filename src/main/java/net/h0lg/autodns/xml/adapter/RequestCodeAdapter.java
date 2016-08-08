package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.model.RequestCode;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;

public class RequestCodeAdapter extends XmlAdapter<String, RequestCode> {

	@Override
	public RequestCode unmarshal(String value) throws Exception {
		return Arrays.stream(RequestCode.values())
				.filter(code -> code.getValue().equalsIgnoreCase(value))
				.findFirst()
				.orElse(null);
	}

	@Override
	public String marshal(RequestCode requestCode) throws Exception {
		if (requestCode == null) {
			return null;
		}

		return requestCode.getValue();
	}
}

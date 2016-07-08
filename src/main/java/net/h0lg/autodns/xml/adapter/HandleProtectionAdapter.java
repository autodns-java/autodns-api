package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.contact.HandleProtection;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;

public class HandleProtectionAdapter extends XmlAdapter<String, HandleProtection> {
	@Override
	public HandleProtection unmarshal(String s) throws Exception {
		return Arrays.stream(HandleProtection.values())
				.filter(hp -> hp.getValue().equalsIgnoreCase(s))
				.findFirst()
				.orElse(null);
	}

	@Override
	public String marshal(HandleProtection handleProtection) throws Exception {
		if (handleProtection == null) {
			return null;
		}

		return handleProtection.getValue();
	}
}

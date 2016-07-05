package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.contact.HandleProtection;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ProtectionAdapter extends XmlAdapter<String, HandleProtection> {
	@Override
	public HandleProtection unmarshal(String s) throws Exception {
		for (HandleProtection protection : HandleProtection.values()) {
			if (protection.getValue().equals(s)) {
				return protection;
			}
		}

		return null;
	}

	@Override
	public String marshal(HandleProtection handleProtection) throws Exception {
		return handleProtection.getValue();
	}
}

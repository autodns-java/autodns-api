package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.contact.HandleExtensionMode;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class HandleExtensionModeAdapter extends XmlAdapter<String, HandleExtensionMode> {
	@Override
	public HandleExtensionMode unmarshal(String s) throws Exception {
		for (HandleExtensionMode mode : HandleExtensionMode.values()) {
			if (mode.getValue().equals(s)) {
				return mode;
			}
		}

		return null;
	}

	@Override
	public String marshal(HandleExtensionMode mode) throws Exception {
		return mode.getValue();
	}
}

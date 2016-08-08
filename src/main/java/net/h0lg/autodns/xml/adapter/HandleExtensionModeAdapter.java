package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.model.contact.HandleExtensionMode;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;

public class HandleExtensionModeAdapter extends XmlAdapter<String, HandleExtensionMode> {
	@Override
	public HandleExtensionMode unmarshal(String s) throws Exception {
		return Arrays.stream(HandleExtensionMode.values())
				.filter(hem -> hem.getValue().equalsIgnoreCase(s))
				.findFirst()
				.orElse(null);
	}

	@Override
	public String marshal(HandleExtensionMode mode) throws Exception {
		if (mode == null) {
			return null;
		}

		return mode.getValue();
	}
}

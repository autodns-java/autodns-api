package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.model.contact.HandleVerification;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;

public class HandleVerificationAdapter extends XmlAdapter<String, HandleVerification> {
	@Override
	public HandleVerification unmarshal(String value) {
		return Arrays.stream(HandleVerification.values())
				.filter(verification -> verification.getValue().equalsIgnoreCase(value))
				.findFirst()
				.orElse(HandleVerification.UNKNOWN);
	}

	@Override
	public String marshal(HandleVerification handleVerification) {
		if (handleVerification == null) {
			return HandleVerification.UNKNOWN.getValue();
		}

		return handleVerification.getValue();
	}
}

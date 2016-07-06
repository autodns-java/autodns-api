package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.contact.HandleGender;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;

public class HandleGenderAdapter extends XmlAdapter<String, HandleGender> {
	@Override
	public HandleGender unmarshal(String s) throws Exception {
		return Arrays.stream(HandleGender.values())
				.filter(hg -> hg.getValue().equalsIgnoreCase(s))
				.findFirst()
				.orElse(HandleGender.UNKNOWN);
	}

	@Override
	public String marshal(HandleGender gender) throws Exception {
		if (gender == null) {
			return HandleGender.UNKNOWN.getValue();
		}
		return gender.getValue();
	}
}

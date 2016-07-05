package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.contact.HandleGender;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class HandleGenderAdapter extends XmlAdapter<String, HandleGender> {
	@Override
	public HandleGender unmarshal(String s) throws Exception {
		for (HandleGender gender : HandleGender.values()) {
			if (gender.getValue().equals(s)) {
				return gender;
			}
		}
		return null;
	}

	@Override
	public String marshal(HandleGender gender) throws Exception {
		return gender.getValue();
	}
}

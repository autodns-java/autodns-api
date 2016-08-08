package net.h0lg.autodns.xml.request.model.contact;

public enum HandleGender {

	UNKNOWN(""),
	MALE("m"),
	FEMALE("f");

	private final String code;

	HandleGender (String code) {
		this.code = code;
	}


	public String getValue() {
		return code;
	}
}

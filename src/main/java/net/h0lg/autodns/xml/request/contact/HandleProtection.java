package net.h0lg.autodns.xml.request.contact;

public enum HandleProtection {

	ALL("a"),
	LIMITED("b");

	private final String code;

	HandleProtection (String code) {
		this.code = code;
	}

	public String getValue() {
		return this.code;
	}
}

package net.h0lg.autodns.xml.request.model;

public enum RequestCode {

	CONTACT_CREATE("0301"), CONTACT_LIST("0304");

	private final String value;

	RequestCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return value;
	}
}

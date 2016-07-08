package net.h0lg.autodns.xml.request;

public enum RequestCode {

	CONTACT_CREATE("0301");

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

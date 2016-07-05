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

	public static RequestCode findByValue(String value) {
		for (RequestCode code : values()) {
			if (code.getValue().equals(value)) {
				return code;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return value;
	}
}

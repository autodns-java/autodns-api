package net.h0lg.autodns.xml.request.contact;

public enum HandleExtensionMode {

	MERGE("merge"),
	REPLACE("replace");

	private final String value;

	HandleExtensionMode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

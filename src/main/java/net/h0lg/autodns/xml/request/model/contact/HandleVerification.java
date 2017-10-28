package net.h0lg.autodns.xml.request.model.contact;

public enum HandleVerification {

	SUCCESS("SUCCESS"),
	FAILED("FAILED"),
	PENDING("PENDING"),
	UNKNOWN("-");

	private String value;

	HandleVerification(String text) {
		this.value = text;
	}

	public String getValue() {
		return value;
	}

}

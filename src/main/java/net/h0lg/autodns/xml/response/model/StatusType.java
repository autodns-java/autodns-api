package net.h0lg.autodns.xml.response.model;

public enum StatusType {

	SUCCESS("S"),
	ERROR("E"),
	NOTIFICATION("N");

	private final String code;

	StatusType(String code) {
		this.code = code;
	}

}

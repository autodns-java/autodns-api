package net.h0lg.autodns.xml.response.model;

public class Status {

	StatusType type;
	String code;
	String text;

	public StatusType getType() {
		return type;
	}

	public void setType(StatusType type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

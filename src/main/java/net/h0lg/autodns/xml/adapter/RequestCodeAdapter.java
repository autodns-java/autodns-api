package net.h0lg.autodns.xml.adapter;

import net.h0lg.autodns.xml.request.RequestCode;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class RequestCodeAdapter extends XmlAdapter<String, RequestCode> {

	@Override
	public RequestCode unmarshal(String value) throws Exception {
		return RequestCode.findByValue(value);
	}

	@Override
	public String marshal(RequestCode o) throws Exception {
		return o.getValue();
	}
}

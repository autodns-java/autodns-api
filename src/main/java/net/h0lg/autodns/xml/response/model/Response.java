package net.h0lg.autodns.xml.response.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
public class Response {


	List<Result> result;

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> results) {
		this.result= results;
	}
}

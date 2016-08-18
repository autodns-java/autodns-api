package net.h0lg.autodns.xml.response.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
public class Response {

	List<Result> results;
}

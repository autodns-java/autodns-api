package net.h0lg.autodns.xml.response.model;

import net.h0lg.autodns.xml.request.model.contact.Handle;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Data {

	// TODO needs to be more generic
	private List<Handle> handles;
	private int count;

	@XmlElement(name = "handle")
	public List<Handle> getHandles() {
		return handles;
	}

	public void setHandles(List<Handle> handles) {
		this.handles = handles;
	}

	@XmlElement(name = "summary")
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

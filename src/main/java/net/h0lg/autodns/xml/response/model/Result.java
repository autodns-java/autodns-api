package net.h0lg.autodns.xml.response.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Result {

	List<Data> dataList;

	Status status;

	List<SystemMessage> systemMessages;

	@XmlElement(name = "data")
	public List<Data> getDataList() {
		return dataList;
	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<SystemMessage> getSystemMessages() {
		return systemMessages;
	}

	public void setSystemMessages(List<SystemMessage> systemMessages) {
		this.systemMessages = systemMessages;
	}
}

package net.h0lg.autodns.xml.request.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class Request {

	private Auth auth;
	private Task task;

	public Auth getAuth() {
		return auth;
	}

	public void setAuth(final Auth auth) {
		this.auth = auth;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(final Task task) {
		this.task = task;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Request request = (Request) o;

		if (getAuth() != null ? !getAuth().equals(request.getAuth()) : request.getAuth() != null) return false;
		return getTask() != null ? getTask().equals(request.getTask()) : request.getTask() == null;

	}

	@Override
	public int hashCode() {
		int result = getAuth() != null ? getAuth().hashCode() : 0;
		result = 31 * result + (getTask() != null ? getTask().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Request{" +
				"auth=" + auth +
				", task=" + task +
				'}';
	}
}

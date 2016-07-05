package net.h0lg.autodns.xml.request;

import net.h0lg.autodns.xml.adapter.RequestCodeAdapter;
import net.h0lg.autodns.xml.request.contact.Handle;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Task {

	private Handle handle;
	private RequestCode code;

	public Handle getHandle() {
		return handle;
	}

	public void setHandle(Handle handle) {
		this.handle = handle;
	}

	@XmlJavaTypeAdapter(RequestCodeAdapter.class)
	public RequestCode getCode() {
		return code;
	}

	public void setCode(RequestCode code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Task task = (Task) o;

		if (getHandle() != null ? !getHandle().equals(task.getHandle()) : task.getHandle() != null) return false;
		return getCode() == task.getCode();

	}

	@Override
	public int hashCode() {
		int result = getHandle() != null ? getHandle().hashCode() : 0;
		result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Task{" +
				"handle=" + handle +
				", code=" + code +
				'}';
	}
}

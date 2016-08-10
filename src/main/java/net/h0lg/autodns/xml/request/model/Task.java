package net.h0lg.autodns.xml.request.model;

import net.h0lg.autodns.xml.adapter.RequestCodeAdapter;
import net.h0lg.autodns.xml.request.model.contact.Handle;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Task {

	private Handle handle;
	private final RequestCode code;
	private View view;

	public Task (RequestCode code) {
		this.code = code;
	}

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

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
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

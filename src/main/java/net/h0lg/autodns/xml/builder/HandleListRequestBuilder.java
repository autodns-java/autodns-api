package net.h0lg.autodns.xml.builder;

import net.h0lg.autodns.xml.request.model.Auth;
import net.h0lg.autodns.xml.request.model.Request;
import net.h0lg.autodns.xml.request.model.RequestCode;
import net.h0lg.autodns.xml.request.model.Task;

public class HandleListRequestBuilder {

	private final Auth auth;

	public HandleListRequestBuilder(final Auth auth) {
		this.auth = auth;
	}

	public Request build() {
		Request request = new Request();
		request.setAuth(auth);

		Task task = Task.builder()
				.code(RequestCode.CONTACT_LIST)
				.build();
		request.setTask(task);

		return request;
	}
}

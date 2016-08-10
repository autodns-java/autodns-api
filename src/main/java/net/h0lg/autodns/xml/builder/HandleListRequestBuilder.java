package net.h0lg.autodns.xml.builder;

import net.h0lg.autodns.xml.request.model.*;

public class HandleListRequestBuilder {

    private final Auth auth;

    public HandleListRequestBuilder(final Auth auth) {
    	this.auth = auth;
    }

    public Request build() {
    	Request request = new Request();
		request.setAuth(auth);

		Task task = new Task(RequestCode.CONTACT_LIST);
		request.setTask(task);

        return request;
    }
}

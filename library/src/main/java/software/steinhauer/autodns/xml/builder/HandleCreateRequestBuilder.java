/*
 * MIT License
 *
 * Copyright (c) 2017 Holger Steinhauer <holger@steinhauer.software>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package software.steinhauer.autodns.xml.builder;

import software.steinhauer.autodns.xml.request.model.Auth;
import software.steinhauer.autodns.xml.request.model.Request;
import software.steinhauer.autodns.xml.request.model.RequestCode;
import software.steinhauer.autodns.xml.request.model.Task;
import software.steinhauer.autodns.xml.request.model.contact.Handle;
import software.steinhauer.util.Assert;

public class HandleCreateRequestBuilder {

	private final Auth auth;
	private Handle handle;
	private boolean forceCreation = false;

	public HandleCreateRequestBuilder(final Auth auth) {
		this.auth = auth;
	}

	public HandleCreateRequestBuilder setHandle(Handle handle) {
		Assert.notNull(handle, "Handle must not be null");

		this.handle = handle;

		return this;
	}

	public HandleCreateRequestBuilder doForceCreation() {
		this.forceCreation = true;
		return this;
	}

	public HandleCreateRequestBuilder doNotForceCreation() {
		this.forceCreation = false;
		return this;
	}

	public Request build() {
		Assert.notNull(handle, "Can not build handle create request without handle.");

		Request request = new Request();
		request.setAuth(auth);

		Task.TaskBuilder task = Task.builder()
				.code(RequestCode.CONTACT_CREATE)
				.handle(handle);

		if (this.forceCreation) {
			task.forceCreation(1);
		}

		request.setTask(task.build());

		return request;
	}

}

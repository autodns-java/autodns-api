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

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

public class Auth {

    private String user;
    private String password;
    private String context;

	public Auth() {
		// Thx JAXB
	}

    public Auth(String username, String password, String context) {
        this.user = username;
        this.password = password;
        this.context = context;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getContext() {
        return context;
    }

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auth auth = (Auth) o;

        if (getUser() != null ? !getUser().equals(auth.getUser()) : auth.getUser() != null) return false;
        if (getPassword() != null ? !getPassword().equals(auth.getPassword()) : auth.getPassword() != null)
            return false;
        return getContext() != null ? getContext().equals(auth.getContext()) : auth.getContext() == null;

    }

    @Override
    public int hashCode() {
        int result = getUser() != null ? getUser().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getContext() != null ? getContext().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}

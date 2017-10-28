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

package software.steinhauer.autodns.xml.request.model.contact;


import com.neovisionaries.i18n.CountryCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.steinhauer.autodns.xml.adapter.CountryCodeAdapter;
import software.steinhauer.autodns.xml.adapter.HandleProtectionAdapter;
import software.steinhauer.autodns.xml.adapter.HandleVerificationAdapter;
import software.steinhauer.autodns.xml.request.model.Owner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Handle {

	private String id;
	private String alias;
	private HandleType type;
	@XmlElement(name = "fname")
	private String firstName;
	@XmlElement(name = "lname")
	private String lastName;
	private String title;
	@XmlElement(name = "organization", required = true)
	private String organisation;
	@XmlElement(name = "address")
	private List<String> addresses;
	@XmlElement(name = "pcode")
	private String postcode;
	private String city;
	private String state;
	@XmlJavaTypeAdapter(CountryCodeAdapter.class)
	private CountryCode country;
	private String phone;
	private String fax;
	private String email;
	@XmlJavaTypeAdapter(HandleProtectionAdapter.class)
	private HandleProtection protection;
	@XmlJavaTypeAdapter(CountryCodeAdapter.class)
	@XmlElement(name = "nic_ref")
	private List<CountryCode> nicReferences;
	private String remarks;
	@XmlElement(name = "reply_to")
	private String replyTo;
	@XmlElement(name = "force_handle_create")
	private HandleForceCreate forceHandleCreate;
	private String comment;
	private Owner owner;
	private HandleExtension extension;
	@XmlJavaTypeAdapter(HandleVerificationAdapter.class)
	private HandleVerification verification;
}

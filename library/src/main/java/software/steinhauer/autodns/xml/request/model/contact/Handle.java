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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

import static software.steinhauer.util.Constants.EMAIL_REGEX;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Handle {


	private String id;

	private String alias;

	@NotNull
	private HandleType type;

	@NotNull
	@Size(min = 1)
	@XmlElement(name = "fname")
	private String firstName;

	@NotNull
	@Size(min = 1)
	@XmlElement(name = "lname")
	private String lastName;

	private String title;

	@NotNull
	@Size(min = 1)
	@XmlElement(name = "organization", required = true)
	private String organisation;

	@NotEmpty
	@XmlElement(name = "address")
	private List<String> addresses;

	@NotNull
	@Size(min = 1)
	@XmlElement(name = "pcode")
	private String postcode;

	@NotNull
	@Size(min = 1)
	private String city;

	private String state;

	@NotNull
	@XmlJavaTypeAdapter(CountryCodeAdapter.class)
	private CountryCode country;

	@NotNull
	@Pattern(regexp = "^\\+\\d{1,3}[-0-9]{1,15}$")
	private String phone;

	@Pattern(regexp = "^\\+\\d{1,3}[-0-9]{1,15}$")
	private String fax;

	@NotNull
	@Pattern(regexp = EMAIL_REGEX)
	private String email;

	private String sip;

	@NotNull
	@XmlJavaTypeAdapter(HandleProtectionAdapter.class)
	private HandleProtection protection;

	@XmlJavaTypeAdapter(CountryCodeAdapter.class)
	@XmlElement(name = "nic_ref")
	private List<CountryCode> nicReferences;

	private String remarks;

	@NotNull
	@Pattern(regexp = EMAIL_REGEX)
	@XmlElement(name = "reply_to")
	private String replyTo;

	@XmlElement(name = "force_handle_create")
	private HandleForceCreate forceHandleCreate;

	private String comment;

	private Owner owner;

	private HandleExtension extension;

	@XmlJavaTypeAdapter(HandleVerificationAdapter.class)
	private HandleVerification verification;

	private Owner updater;
}

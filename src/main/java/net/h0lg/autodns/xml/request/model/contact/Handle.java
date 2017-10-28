package net.h0lg.autodns.xml.request.model.contact;


import com.neovisionaries.i18n.CountryCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.h0lg.autodns.xml.adapter.CountryCodeAdapter;
import net.h0lg.autodns.xml.adapter.HandleProtectionAdapter;
import net.h0lg.autodns.xml.request.model.Owner;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
}

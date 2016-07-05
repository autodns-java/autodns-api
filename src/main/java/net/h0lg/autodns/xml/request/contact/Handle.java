package net.h0lg.autodns.xml.request.contact;


import com.neovisionaries.i18n.CountryCode;
import net.h0lg.autodns.xml.adapter.CountryCodeAdapter;
import net.h0lg.autodns.xml.adapter.ProtectionAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

public class Handle {

	private String id;
	private HandleType type;
	private String firstName;
	private String lastName;
	private String title;
	private String organisation = null;
	private List<String> addresses;
	private String postcode;
	private String city;
	private String state;
	private CountryCode country;
	private String phone;
	private String fax;
	private String email;
	private HandleProtection protection;
	private List<CountryCode> nicReferences;
	private String remarks;
	private String replyTo;
	private HandleForceCreate forceHandleCreate;
	private String comment;

	private HandleExtension extension;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HandleType getType() {
		return type;
	}

	public void setType(HandleType type) {
		this.type = type;
	}

	@XmlElement(name = "fname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name = "lname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "organization", required = true)
	public String getOrganisation() {
		if (organisation == null) {
			return "";
		}
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	@XmlElement(name = "address")
	public List<String> getAddresses() {
		if (addresses == null) {
			this.addresses = new ArrayList<>(3);
		}
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	@XmlElement(name = "pcode")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@XmlJavaTypeAdapter(CountryCodeAdapter.class)
	public CountryCode getCountry() {
		return country;
	}

	public void setCountry(CountryCode country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlJavaTypeAdapter(ProtectionAdapter.class)
	public HandleProtection getProtection() {
		return protection;
	}

	public void setProtection(HandleProtection protection) {
		this.protection = protection;
	}

	@XmlJavaTypeAdapter(CountryCodeAdapter.class)
	@XmlElement(name = "nic_ref")
	public List<CountryCode> getNicReferences() {
		if (nicReferences == null) {
			nicReferences = new ArrayList<>();
		}
		return nicReferences;
	}

	public void setNicReferences(List<CountryCode> nicReferences) {
		this.nicReferences = nicReferences;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@XmlElement(name = "reply_to")
	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	@XmlElement(name = "force_handle_create")
	public HandleForceCreate getForceHandleCreate() {
		return forceHandleCreate;
	}

	public void setForceHandleCreate(HandleForceCreate forceHandleCreate) {
		this.forceHandleCreate = forceHandleCreate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public HandleExtension getExtension() {
		return extension;
	}

	public void setExtension(HandleExtension extension) {
		this.extension = extension;
	}
}

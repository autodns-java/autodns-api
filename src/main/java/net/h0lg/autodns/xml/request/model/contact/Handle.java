package net.h0lg.autodns.xml.request.model.contact;


import com.neovisionaries.i18n.CountryCode;
import net.h0lg.autodns.xml.adapter.CountryCodeAdapter;
import net.h0lg.autodns.xml.adapter.HandleProtectionAdapter;

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

	@XmlJavaTypeAdapter(HandleProtectionAdapter.class)
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Handle handle = (Handle) o;

		if (getId() != null ? !getId().equals(handle.getId()) : handle.getId() != null) return false;
		if (getType() != handle.getType()) return false;
		if (getFirstName() != null ? !getFirstName().equals(handle.getFirstName()) : handle.getFirstName() != null)
			return false;
		if (getLastName() != null ? !getLastName().equals(handle.getLastName()) : handle.getLastName() != null)
			return false;
		if (getTitle() != null ? !getTitle().equals(handle.getTitle()) : handle.getTitle() != null) return false;
		if (getOrganisation() != null ? !getOrganisation().equals(handle.getOrganisation()) : handle.getOrganisation() != null)
			return false;
		if (getAddresses() != null ? !getAddresses().equals(handle.getAddresses()) : handle.getAddresses() != null)
			return false;
		if (getPostcode() != null ? !getPostcode().equals(handle.getPostcode()) : handle.getPostcode() != null)
			return false;
		if (getCity() != null ? !getCity().equals(handle.getCity()) : handle.getCity() != null) return false;
		if (getState() != null ? !getState().equals(handle.getState()) : handle.getState() != null) return false;
		if (getCountry() != handle.getCountry()) return false;
		if (getPhone() != null ? !getPhone().equals(handle.getPhone()) : handle.getPhone() != null) return false;
		if (getFax() != null ? !getFax().equals(handle.getFax()) : handle.getFax() != null) return false;
		if (getEmail() != null ? !getEmail().equals(handle.getEmail()) : handle.getEmail() != null) return false;
		if (getProtection() != handle.getProtection()) return false;
		if (getNicReferences() != null ? !getNicReferences().equals(handle.getNicReferences()) : handle.getNicReferences() != null)
			return false;
		if (getRemarks() != null ? !getRemarks().equals(handle.getRemarks()) : handle.getRemarks() != null)
			return false;
		if (getReplyTo() != null ? !getReplyTo().equals(handle.getReplyTo()) : handle.getReplyTo() != null)
			return false;
		if (getForceHandleCreate() != handle.getForceHandleCreate()) return false;
		if (getComment() != null ? !getComment().equals(handle.getComment()) : handle.getComment() != null)
			return false;
		return getExtension() != null ? getExtension().equals(handle.getExtension()) : handle.getExtension() == null;

	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getType() != null ? getType().hashCode() : 0);
		result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
		result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		result = 31 * result + (getOrganisation() != null ? getOrganisation().hashCode() : 0);
		result = 31 * result + (getAddresses() != null ? getAddresses().hashCode() : 0);
		result = 31 * result + (getPostcode() != null ? getPostcode().hashCode() : 0);
		result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
		result = 31 * result + (getState() != null ? getState().hashCode() : 0);
		result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
		result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
		result = 31 * result + (getFax() != null ? getFax().hashCode() : 0);
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		result = 31 * result + (getProtection() != null ? getProtection().hashCode() : 0);
		result = 31 * result + (getNicReferences() != null ? getNicReferences().hashCode() : 0);
		result = 31 * result + (getRemarks() != null ? getRemarks().hashCode() : 0);
		result = 31 * result + (getReplyTo() != null ? getReplyTo().hashCode() : 0);
		result = 31 * result + (getForceHandleCreate() != null ? getForceHandleCreate().hashCode() : 0);
		result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
		result = 31 * result + (getExtension() != null ? getExtension().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Handle{" +
				"id='" + id + '\'' +
				", type=" + type +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", title='" + title + '\'' +
				", organisation='" + organisation + '\'' +
				", addresses=" + addresses +
				", postcode='" + postcode + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", country=" + country +
				", phone='" + phone + '\'' +
				", fax='" + fax + '\'' +
				", email='" + email + '\'' +
				", protection=" + protection +
				", nicReferences=" + nicReferences +
				", remarks='" + remarks + '\'' +
				", replyTo='" + replyTo + '\'' +
				", forceHandleCreate=" + forceHandleCreate +
				", comment='" + comment + '\'' +
				", extension=" + extension +
				'}';
	}
}

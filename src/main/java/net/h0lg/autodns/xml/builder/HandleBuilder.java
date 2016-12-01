package net.h0lg.autodns.xml.builder;

import com.neovisionaries.i18n.CountryCode;
import net.h0lg.autodns.xml.request.model.Owner;
import net.h0lg.autodns.xml.request.model.contact.*;

import java.util.List;

public class HandleBuilder {

    private String id;
    private String alias;
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
    private Owner owner;

    private HandleExtension extension;

    public Handle build() {
    	Handle handle = new Handle(id, alias, type, firstName, lastName, title, organisation, addresses, postcode, city, state, country, phone, fax, email, protection, nicReferences, remarks, replyTo, forceHandleCreate, comment, owner);

        return handle;
    }

    private HandleBuilder() {
    }


    public static HandleBuilder getCreateHandleBuilder() {
    	return new HandleBuilder();
	}

	public String getId() {
		return id;
	}

	public HandleBuilder setId(String id) {
		this.id = id;
		return this;
	}

	public String getAlias() {
		return alias;
	}

	public HandleBuilder setAlias(String alias) {
		this.alias = alias;
		return this;
	}

	public HandleType getType() {
		return type;
	}

	public HandleBuilder setType(HandleType type) {
		this.type = type;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public HandleBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public HandleBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public HandleBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getOrganisation() {
		return organisation;
	}

	public HandleBuilder setOrganisation(String organisation) {
		this.organisation = organisation;
		return this;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public HandleBuilder setAddresses(List<String> addresses) {
		this.addresses = addresses;
		return this;
	}

	public String getPostcode() {
		return postcode;
	}

	public HandleBuilder setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	public String getCity() {
		return city;
	}

	public HandleBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public HandleBuilder setState(String state) {
		this.state = state;
		return this;
	}

	public CountryCode getCountry() {
		return country;
	}

	public HandleBuilder setCountry(CountryCode country) {
		this.country = country;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public HandleBuilder setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getFax() {
		return fax;
	}

	public HandleBuilder setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public HandleBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public HandleProtection getProtection() {
		return protection;
	}

	public HandleBuilder setProtection(HandleProtection protection) {
		this.protection = protection;
		return this;
	}

	public List<CountryCode> getNicReferences() {
		return nicReferences;
	}

	public HandleBuilder setNicReferences(List<CountryCode> nicReferences) {
		this.nicReferences = nicReferences;
		return this;
	}

	public String getRemarks() {
		return remarks;
	}

	public HandleBuilder setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public HandleBuilder setReplyTo(String replyTo) {
		this.replyTo = replyTo;
		return this;
	}

	public HandleForceCreate getForceHandleCreate() {
		return forceHandleCreate;
	}

	public HandleBuilder setForceHandleCreate(HandleForceCreate forceHandleCreate) {
		this.forceHandleCreate = forceHandleCreate;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public HandleBuilder setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public Owner getOwner() {
		return owner;
	}

	public HandleBuilder setOwner(Owner owner) {
		this.owner = owner;
		return this;
	}

	public HandleExtension getExtension() {
		return extension;
	}

	public HandleBuilder setExtension(HandleExtension extension) {
		this.extension = extension;
		return this;
	}
}

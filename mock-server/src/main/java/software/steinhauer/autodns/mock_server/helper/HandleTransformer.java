package software.steinhauer.autodns.mock_server.helper;

import software.steinhauer.autodns.mock_server.persistence.model.Handle;

public class HandleTransformer {

	public static Handle toMockHandle(software.steinhauer.autodns.xml.request.model.contact.Handle handle) {
		return Handle.builder()
				.type(handle.getType())
				.firstName(handle.getFirstName())
				.lastName(handle.getLastName())
				.title(handle.getTitle())
				.organisation(handle.getOrganisation())
				.addresses(handle.getAddresses())
				.postcode(handle.getPostcode())
				.city(handle.getPostcode())
				.state(handle.getState())
				.countryCode(handle.getCountry())
				.phone(handle.getPhone())
				.fax(handle.getFax())
				.email(handle.getEmail())
				.sip(handle.getSip())
				.protection(handle.getProtection())
				.nicReferences(handle.getNicReferences())
				.remarks(handle.getRemarks())
				.build();
	}

	public static software.steinhauer.autodns.xml.request.model.contact.Handle toAutoDnsHandle(Handle handle) {
		return software.steinhauer.autodns.xml.request.model.contact.Handle.builder()
				.type(handle.getType())
				.firstName(handle.getFirstName())
				.lastName(handle.getLastName())
				.title(handle.getTitle())
				.organisation(handle.getOrganisation())
				.addresses(handle.getAddresses())
				.postcode(handle.getPostcode())
				.city(handle.getPostcode())
				.state(handle.getState())
				.country(handle.getCountryCode())
				.phone(handle.getPhone())
				.fax(handle.getFax())
				.email(handle.getEmail())
				.sip(handle.getSip())
				.protection(handle.getProtection())
				.nicReferences(handle.getNicReferences())
				.remarks(handle.getRemarks())
				.build();
	}
}

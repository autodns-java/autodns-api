package software.steinhauer.autodns.mock_server.persistence.model;

import com.neovisionaries.i18n.CountryCode;
import lombok.*;
import software.steinhauer.autodns.xml.request.model.NicReference;
import software.steinhauer.autodns.xml.request.model.contact.HandleProtection;
import software.steinhauer.autodns.xml.request.model.contact.HandleType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(doNotUseGetters = true)
@Entity
@Table
public class Handle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private HandleType type;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	private String title;

	@NotNull
	private String organisation;

	@NotNull
	@Size(min = 1, max = 3)
	@Column(name = "address")
	@ElementCollection
	private List<String> addresses;

	@NotNull
	@Column(name = "pcode")
	private String postcode;

	@NotNull
	private String city;

	private String state;

	@Column(name = "country")
	private CountryCode countryCode;

	@NotNull
	private String phone;

	private String fax;

	@NotNull
	private String email;

	private String sip;

	private HandleProtection protection;

	@Column(name = "nic_ref")
	@ElementCollection
	private List<NicReference> nicReferences;

	private String remarks;
}

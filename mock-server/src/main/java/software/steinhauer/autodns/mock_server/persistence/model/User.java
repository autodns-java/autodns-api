package software.steinhauer.autodns.mock_server.persistence.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Size(min = 1)
	@Column(name = "username", unique = true)
	private String username;

	@NotNull
	@Size(min = 1)
	private String password;

	@NotNull
	@Size(min = 1)
	private String context;


}

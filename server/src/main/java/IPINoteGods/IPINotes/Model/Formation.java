package IPINoteGods.IPINotes.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Entity
@Table(name = "formation")
public class Formation {
	
	@Id 
	@GeneratedValue
	private Long id;	
	private String nom;
	private Integer nombreAnnees;
	private Boolean isSemestriel;
	
	@OneToMany(mappedBy = "sessionId.formation")
	private Set<Session> sessions = new HashSet<Session>();	
}

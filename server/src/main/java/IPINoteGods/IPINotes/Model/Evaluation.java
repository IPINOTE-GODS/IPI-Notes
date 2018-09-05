package IPINoteGods.IPINotes.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "evaluation")
public class Evaluation {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String Note;
	private String commentaire;
	
	@OneToMany(mappedBy = "sessionId.evaluation")
	private Set<Session> sessions = new HashSet<Session>();	
	

}

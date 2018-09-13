package IPINoteGods.IPINotes.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "etudiant")
public class Etudiant extends Personne{
	
	@OneToMany(mappedBy = "sessionId.etudiant")
	private Set<Session> sessions = new HashSet<Session>();	

}

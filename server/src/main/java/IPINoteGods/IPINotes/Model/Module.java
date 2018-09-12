package IPINoteGods.IPINotes.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Entity
@Table(name = "module")
public class Module {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nom;
	private String matiere;
	
	@ManyToMany()
	@JoinTable(name = "module_enseignant", joinColumns = @JoinColumn(name = "id_module"),
	              inverseJoinColumns = @JoinColumn(name = "id_enseignant"))
	Set<Enseignant> enseignants = new HashSet<Enseignant>();
	
	@OneToMany(mappedBy = "sessionId.module")
	private Set<Session> sessions = new HashSet<Session>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}	
		
}

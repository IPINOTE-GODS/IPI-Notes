package IPINoteGods.IPINotes.Model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNombreAnnees() {
		return nombreAnnees;
	}

	public void setNombreAnnees(Integer nombreAnnees) {
		this.nombreAnnees = nombreAnnees;
	}

	public Boolean getIsSemestriel() {
		return isSemestriel;
	}

	public void setIsSemestriel(Boolean isSemestriel) {
		this.isSemestriel = isSemestriel;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}	
}

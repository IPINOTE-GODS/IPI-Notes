package IPINoteGods.IPINotes.Model;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Entity
@Table(name = "session")
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Embedded 
	@JsonIgnore
	private SessionId sessionId;
	
	@JsonIgnore
	private SessionId getSessionId() {
		return this.sessionId;
	}
	
	@Column(name="annee")
	private int annee;
	
	public Session() {}
	public Session (int annee) {
		this.annee = annee;
	}
	@JsonIgnore
    public Etudiant getEtudiant() {
    	return getSessionId().getEtudiant();
    }
    public void setEtudiant(Etudiant etudiant) {
    	getSessionId().setEtudiant(etudiant);
    }
	@JsonIgnore
    public Module getModule() {
    	return  getSessionId().getModule();
    }
    
    public void setModule(Module module) {
    	getSessionId().setModule(module); 
    }
	@JsonIgnore
    public Formation getFormation() {
    	return getSessionId().getFormation();
    }
    
    public void setFormation(Formation formation) {
    	if(sessionId == null) {
    		sessionId = new SessionId();
    	}
    	getSessionId().setFormation(formation);
    }
	@JsonIgnore
    public Evaluation getEvaluation() {
    	return getSessionId().getEvaluation();
    }
    
    public void setEvaluation(Evaluation evaluation) {
    	getSessionId().setEvaluation(evaluation);
    }
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
}

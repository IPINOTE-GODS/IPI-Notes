package IPINoteGods.IPINotes.Model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "session")
public class Session {
	
	@Id 
	private SessionId sessionId;
	
	private Integer annee;
    
    public Etudiant getEtudiant() {
    	return getSessionId().getEtudiant();
    }
    
    public void setEtudiant(Etudiant etudiant) {
    	getSessionId().setEtudiant(etudiant);
    }
	
    public Module getModule() {
    	return  getSessionId().getModule();
    }
    
    public void setModule(Module module) {
    	getSessionId().setModule(module); 
    }
    
    public Formation getFormation() {
    	return getSessionId().getFormation();
    }
    
    public void setFormation(Formation formation) {
    	getSessionId().setFormation(formation);
    }
    
    public Evaluation getEvaluation() {
    	return getSessionId().getEvaluation();
    }
    
    public void setEvaluation(Evaluation evaluation) {
    	getSessionId().setEvaluation(evaluation);
    }
}

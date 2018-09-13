package IPINoteGods.IPINotes.Model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Embeddable
public class SessionId implements java.io.Serializable {
	
	private static final long serialVersionUID = -235863222752033045L;

	@ManyToOne
    @JoinColumn(name = "id_etudiant", nullable = true)
    private Etudiant etudiant;
    
    @ManyToOne
    @JoinColumn(name = "id_module", nullable = true)
    private Module module;
    
    @ManyToOne
    @JoinColumn(name = "id_formation", nullable = true)
    private Formation formation;
    
    @ManyToOne
    @JoinColumn(name = "id_evaluation", nullable = true)
    private Evaluation evaluation;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
}

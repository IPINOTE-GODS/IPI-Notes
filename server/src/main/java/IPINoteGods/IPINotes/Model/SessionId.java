package IPINoteGods.IPINotes.Model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Embeddable
public class SessionId implements java.io.Serializable {
	
	private static final long serialVersionUID = -235863222752033045L;

	@ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;
    
    @ManyToOne
    @JoinColumn(name = "id_module")
    private Module module;
    
    @ManyToOne
    @JoinColumn(name = "id_formation")
    private Formation formation;
    
    @ManyToOne
    @JoinColumn(name = "id_evaluation")
    private Evaluation evaluation;
}

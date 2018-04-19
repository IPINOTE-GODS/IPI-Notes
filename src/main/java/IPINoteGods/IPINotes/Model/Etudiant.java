package IPINoteGods.IPINotes.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
//@ToString @EqualsAndHashCode
public class Etudiant {
	
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
}

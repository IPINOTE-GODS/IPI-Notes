package IPINoteGods.IPINotes.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "enseignants")
public class Enseignant extends Personne{
	
	@ManyToMany(mappedBy = "enseignants")
	Set<Module> modules;
}

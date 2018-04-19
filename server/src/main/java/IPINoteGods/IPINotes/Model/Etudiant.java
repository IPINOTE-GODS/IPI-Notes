package IPINoteGods.IPINotes.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Etudiant {
	
	@Id @GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

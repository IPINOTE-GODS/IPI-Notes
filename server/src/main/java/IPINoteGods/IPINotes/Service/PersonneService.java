package IPINoteGods.IPINotes.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IPINoteGods.IPINotes.Model.Personne;
import IPINoteGods.IPINotes.Repository.PersonneRepository;

@Service
public class PersonneService {
	
	@Autowired
	private PersonneRepository personneRepository;

	public Optional<Personne> getByUsername(String username) {
		return personneRepository.findByNom(username);
	}

}
package IPINoteGods.IPINotes.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IPINoteGods.IPINotes.Model.Enseignant;
import IPINoteGods.IPINotes.Model.Personne;
import IPINoteGods.IPINotes.Repository.EnseignantRepository;

@Service
public class EnseignantService {

	@Autowired
	private EnseignantRepository enseignantRepository;
	
	public List<Enseignant> findAll() {
		return enseignantRepository.findAll();
	}
	
	public Enseignant save(Enseignant e) {
		return enseignantRepository.save(e);
	}

	public void deleteAll() {
		enseignantRepository.deleteAll();		
	}

	public void delete(long id) {
		enseignantRepository.deleteById(id);
	}

	public Optional<Enseignant> getById(long id) {
		return enseignantRepository.findById(id);
	}

	
	public Optional<Personne> getByUsername(String username) {
		return enseignantRepository.findByNom(username);
	}
	
}
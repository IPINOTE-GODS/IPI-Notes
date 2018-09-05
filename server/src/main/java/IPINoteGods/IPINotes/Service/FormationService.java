package IPINoteGods.IPINotes.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IPINoteGods.IPINotes.Model.Formation;
import IPINoteGods.IPINotes.Repository.FormationRepository;

@Service
public class FormationService {

	@Autowired
	private FormationRepository formationRepository;
	
	public List<Formation> findAll() {
		return formationRepository.findAll();
	}
	
	public Formation save(Formation e) {
		return formationRepository.save(e);
	}

	public void deleteAll() {
		formationRepository.deleteAll();		
	}

	public void delete(long id) {
		formationRepository.deleteById(id);
	}

	public Optional<Formation> getById(long id) {
		return formationRepository.findById(id);
	}
}
	
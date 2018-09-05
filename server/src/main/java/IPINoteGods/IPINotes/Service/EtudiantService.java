package IPINoteGods.IPINotes.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IPINoteGods.IPINotes.Model.Etudiant;
import IPINoteGods.IPINotes.Model.Formation;
import IPINoteGods.IPINotes.Model.Module;
import IPINoteGods.IPINotes.Model.Session;
import IPINoteGods.IPINotes.Repository.EtudiantRepository;

@Service
@Transactional
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	public List<Etudiant> findAll() {
		return etudiantRepository.findAll();
	}
	
	public Etudiant save(Etudiant e) {
		return etudiantRepository.save(e);
	}

	public void deleteAll() {
		etudiantRepository.deleteAll();		
	}

	public void delete(long id) {
		etudiantRepository.deleteById(id);
	}

	public Optional<Etudiant> getById(long id) {
		return etudiantRepository.findById(id);
	}
	
}
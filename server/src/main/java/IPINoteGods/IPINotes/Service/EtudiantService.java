package IPINoteGods.IPINotes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IPINoteGods.IPINotes.Model.Etudiant;
import IPINoteGods.IPINotes.Repository.EtudiantRepository;

@Service
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	public List<Etudiant> findAll() {
		return etudiantRepository.findAll();
	}
	
	public void save(Etudiant e) {
		etudiantRepository.save(e);
	}

	public void deleteAll() {
		etudiantRepository.deleteAll();		
	}
	
}
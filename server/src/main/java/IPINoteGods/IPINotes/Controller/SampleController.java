package IPINoteGods.IPINotes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IPINoteGods.IPINotes.Model.Etudiant;
import IPINoteGods.IPINotes.Service.EtudiantService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class SampleController {
	
	@Autowired
	EtudiantService etudiantService;

	@RequestMapping("etudiants/all")
	public List<Etudiant> testPage() {
		
		//spawnFakeEtudiants();
		
		List<Etudiant> etudiants = etudiantService.findAll();
		
		return etudiants;
	}
	
	@RequestMapping("etudiants/delete/all")
	public void deleteAllEtudiants() {
		etudiantService.deleteAll();
	}
	
	private void spawnFakeEtudiants() {
		{
			Etudiant hello = new Etudiant();
			hello.setName("Carrel");
			etudiantService.save(hello);
		}
		{
			Etudiant hello = new Etudiant();
			hello.setName("Jebabli");
			etudiantService.save(hello);
		}
	}
	
}
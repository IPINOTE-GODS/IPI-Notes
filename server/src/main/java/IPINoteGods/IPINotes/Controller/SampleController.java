package IPINoteGods.IPINotes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IPINoteGods.IPINotes.Model.Etudiant;
import IPINoteGods.IPINotes.Service.EtudiantService;

@RestController
@RequestMapping("/")
public class SampleController {
	
	@Autowired
	EtudiantService etudiantService;

	@RequestMapping("test")
	public List<Etudiant> testPage() {
		
		spawnFakeEtudiants();
		
		List<Etudiant> etudiants = etudiantService.findAll();
		
		return etudiants;
	}
	
	private void spawnFakeEtudiants() {
		{
			Etudiant hello = new Etudiant();
			hello.setName("EtName");
			etudiantService.save(hello);
		}
		{
			Etudiant hello = new Etudiant();
			hello.setName("EtName2");
			etudiantService.save(hello);
		}
	}
	
}
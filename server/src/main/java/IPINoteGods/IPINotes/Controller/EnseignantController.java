package IPINoteGods.IPINotes.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IPINoteGods.IPINotes.Exception.UserNotFoundException;
import IPINoteGods.IPINotes.Model.Enseignant;
import IPINoteGods.IPINotes.Service.EnseignantService;

@RestController
@RequestMapping("/enseignants")
@CrossOrigin
public class EnseignantController {
	
	@Autowired
	private EnseignantService enseignantService;

	/**
	 * Renvoie un étudiant par son ID.
	 *
	 * @param id l'ID de l'étudiant
	 * @return l'étudiant correspondant à l'ID
	 */
	@GetMapping("/{id}")
	public Enseignant get(@PathVariable long id) {
		Optional<Enseignant> enseignant = enseignantService.getById(id);
		if(!enseignant.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return enseignant.get();	 
	}

}

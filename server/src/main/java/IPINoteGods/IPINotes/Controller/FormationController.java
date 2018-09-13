package IPINoteGods.IPINotes.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import IPINoteGods.IPINotes.Exception.EvaluationNotFoundException;
import IPINoteGods.IPINotes.Exception.FormationNotFoundException;
import IPINoteGods.IPINotes.Model.Evaluation;
import IPINoteGods.IPINotes.Model.Formation;
import IPINoteGods.IPINotes.Model.Session;
import IPINoteGods.IPINotes.Service.EvaluationService;
import IPINoteGods.IPINotes.Service.FormationService;
import IPINoteGods.IPINotes.Service.SessionService;

@RestController
@RequestMapping("/formation")
@CrossOrigin
public class FormationController {
	
	@Autowired
	FormationService formationService;
	@Autowired
	SessionService sessionService;

	/**
	 * Renvoie la liste des formations.
	 *
	 * @return Toutes les formations
	 */
	@RequestMapping("/all")
	public List<Formation> getAll() {	
		List<Formation> evaluations = formationService.findAll();
		return evaluations;
	}
	
	/**
	 * Supprime toutes les formations.
	 */
	@RequestMapping("/delete/all")
	public void deleteAll() {
		formationService.deleteAll();
	}
	
	/**
	 * Renvoie une formation par son ID.
	 *
	 * @param id l'ID de la formation
	 * @return la formation correspondant à l'ID
	 */
	@GetMapping("/{id}")
	public Formation get(@PathVariable long id) {
		Optional<Formation> formation = formationService.getById(id);
		if(!formation.isPresent()) {
			throw new FormationNotFoundException("id-"+id);
		}
		return formation.get();	 
	}
	
	/**
	 * Crée une nouvelle formation pour l'année donnée
	 *
	 * @param formation la formation à enregistrer
	 * @return une réponse HTTP Created
	 */
	@PostMapping("/save/{annee}")
	public ResponseEntity<Object> create(@RequestBody Formation formation, @PathVariable int annee) {
		Session session = new Session(annee);
		Formation savedFormation = formationService.save(formation);
		session.setFormation(savedFormation);
		sessionService.save(session);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedFormation.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}

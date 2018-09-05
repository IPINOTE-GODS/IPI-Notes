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
import IPINoteGods.IPINotes.Model.Evaluation;
import IPINoteGods.IPINotes.Service.EvaluationService;

@RestController
@RequestMapping("/evaluation")
@CrossOrigin
public class EvaluationController {
	
	@Autowired
	EvaluationService evaluationService;

	/**
	 * Renvoie la liste des évaluations.
	 *
	 * @return Toutes les évaluations
	 */
	@RequestMapping("/all")
	public List<Evaluation> getAll() {	
		List<Evaluation> evaluations = evaluationService.findAll();
		return evaluations;
	}
	
	/**
	 * Supprime toutes les évaluations.
	 */
	@RequestMapping("/delete/all")
	public void deleteAll() {
		evaluationService.deleteAll();
	}
	
	/**
	 * Renvoie une évaluation par son ID.
	 *
	 * @param id l'ID de l'évaluation
	 * @return l'évaluation correspondant à l'ID
	 */
	@GetMapping("/{id}")
	public Evaluation get(@PathVariable long id) {
		Optional<Evaluation> evaluation = evaluationService.getById(id);
		if(!evaluation.isPresent()) {
			throw new EvaluationNotFoundException("id-"+id);
		}
		return evaluation.get();	 
	}
	
	/**
	 * Crée une nouvelle évaluation
	 *
	 * @param evaluation l'évaluation à enregistrer
	 * @return une réponse HTTP Created
	 */
	@PostMapping("/save")
	public ResponseEntity<Object> create(@RequestBody Evaluation evaluation) {
		Evaluation savedEvaluation = evaluationService.save(evaluation);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedEvaluation.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}

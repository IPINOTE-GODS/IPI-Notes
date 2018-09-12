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
import IPINoteGods.IPINotes.Exception.ModuleNotFoundException;
import IPINoteGods.IPINotes.Model.Evaluation;
import IPINoteGods.IPINotes.Model.Formation;
import IPINoteGods.IPINotes.Model.Module;
import IPINoteGods.IPINotes.Service.EvaluationService;
import IPINoteGods.IPINotes.Service.FormationService;
import IPINoteGods.IPINotes.Service.ModuleService;

@RestController
@RequestMapping("/module")
@CrossOrigin
public class ModuleController {
	
	@Autowired
	ModuleService moduleService;

	/**
	 * Renvoie la liste des modules.
	 *
	 * @return Tous les modules
	 */
	@RequestMapping("/all")
	public List<Module> getAll() {	
		List<Module> evaluations = moduleService.findAll();
		return evaluations;
	}
	
	/**
	 * Supprime tous les modules.
	 */
	@RequestMapping("/delete/all")
	public void deleteAll() {
		moduleService.deleteAll();
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		moduleService.delete(id);
	}
	
	/**
	 * Renvoie un module par son ID.
	 *
	 * @param id l'ID du module
	 * @return le module correspondant à l'ID
	 */
	@GetMapping("/{id}")
	public Module get(@PathVariable long id) {
		Optional<Module> module = moduleService.getById(id);
		if(!module.isPresent()) {
			throw new ModuleNotFoundException("id-"+id);
		}
		return module.get();	 
	}
	
	/**
	 * Crée un nouveau module
	 *
	 * @param module le module à enregistrer
	 * @return une réponse HTTP Created
	 */
	@PostMapping("/save")
	public ResponseEntity<Object> create(@RequestBody Module module) {
		Module savedModule = moduleService.save(module);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedModule.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}

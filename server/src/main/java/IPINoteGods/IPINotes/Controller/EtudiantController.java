
package IPINoteGods.IPINotes.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import IPINoteGods.IPINotes.Exception.EtudiantNotFoundException;
import IPINoteGods.IPINotes.Model.Etudiant;
import IPINoteGods.IPINotes.Model.Formation;
import IPINoteGods.IPINotes.Model.Module;
import IPINoteGods.IPINotes.Model.Session;
import IPINoteGods.IPINotes.Service.EtudiantService;
import IPINoteGods.IPINotes.Service.FormationService;
import IPINoteGods.IPINotes.Service.ModuleService;
import IPINoteGods.IPINotes.Service.SessionService;


@RestController
@RequestMapping("/etudiants")
@CrossOrigin
public class EtudiantController {
	
	@Autowired
	EtudiantService etudiantService;
	@Autowired
	FormationService formationService;
	@Autowired
	SessionService sessionService;
	@Autowired
	ModuleService moduleService;
	/**
	 * Renvoie la liste des étudiants.
	 *
	 * @return Tous les étudiants
	 */
	@RequestMapping("/all")
	public List<Etudiant> getAll() {	
		List<Etudiant> etudiants = etudiantService.findAll();
		return etudiants;
	}
	
	/**
	 * Supprime tous les étudiants.
	 */
	@RequestMapping("/delete/all")
	public void deleteAll() {
		etudiantService.deleteAll();
	}
	
	/**
	 * Renvoie un étudiant par son ID.
	 *
	 * @param id l'ID de l'étudiant
	 * @return l'étudiant correspondant à l'ID
	 */
	@GetMapping("/{id}")
	public Etudiant get(@PathVariable long id) {
		Optional<Etudiant> etudiant = etudiantService.getById(id);
		if(!etudiant.isPresent()) {
			throw new EtudiantNotFoundException("id-"+id);
		}
		return etudiant.get();	 
	}
	
	/**
	 * Crée un nouvel étudiant
	 *
	 * @param etudiant l'étudiant à enregistrer
	 * @return une réponse HTTP Created
	 */
	@PostMapping("/save")
	public ResponseEntity<Object> create(@RequestBody Etudiant etudiant) {
		Etudiant savedEtudiant = etudiantService.save(etudiant);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedEtudiant.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	/**
	 * Ajoute un étudiant à une formation
	 *
	 * @param etudiant l'étudiant à enregistrer
	 * @return une réponse HTTP Created
	 */
	@PostMapping("/{etudiant_id}/{formation_id}")
	public ResponseEntity<Object> linkEtudiant(@PathVariable Long etudiant_id,  @PathVariable Long formation_id) {
		Optional<Etudiant> etudiant = etudiantService.getById(etudiant_id);
		Optional<Formation> formation = formationService.getById(formation_id);
		List<Session> sessions = sessionService.findByFormation(formation.orElse(null));
		for(int i=0 ; i<sessions.size(); i++) {
			Session current_session = sessions.get(i);
			if(current_session.getEtudiant() == null) {
				current_session.setEtudiant(etudiant.orElse(null));
				sessionService.save(current_session);
			} else {
				Session new_session = new Session();
				new_session.setFormation(current_session.getFormation());
				new_session.setAnnee(current_session.getAnnee());
				new_session.setModule(current_session.getModule());
				new_session.setEtudiant(etudiant.orElse(null));
				sessionService.save(new_session);
			}
		}
					
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(etudiant_id).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	
	/**
	 * Met à jour l'étudiant.
	 *
	 * @param etudiant l'étudiant à modifier
	 * @param id de l'étudiant à modifier
	 * @return une réponse HTTP No Content
	 */
	@PutMapping("/{id}/edit")
	public ResponseEntity<Object> update(@RequestBody Etudiant etudiant, @PathVariable Long id) {
		Optional<Etudiant> optEtudiant = etudiantService.getById(id);
		if(!optEtudiant.isPresent()) {
			throw new EtudiantNotFoundException("id-"+id);
		}
		etudiant.setId(id);
		etudiantService.save(etudiant);
		
		return ResponseEntity.noContent().build();
	}
	
    /**
     * Supprime l'étudiant
     *
     * @param id de l'étudiant à supprimer
     */
    @DeleteMapping("/{id}/delete") 
    public void delete(@PathVariable long id) {
    	etudiantService.delete(id); 
    }
    
	/**
	 * Lister les étudiants du module
	 *
	 * @param module et formation
	 * @return une réponse HTTP OK
	 */
	@RequestMapping("/all/{module_id}/{formation_id}")
	public List<Etudiant> listEtudiant( @PathVariable Long module_id,  @PathVariable Long formation_id) {
		Optional<Module> module = moduleService.getById(module_id);
		Optional<Formation> formation = formationService.getById(formation_id);
		List<Etudiant> etudiants = etudiantService.findAllByModuleAndFormation(formation.get(),module.get());
		return etudiants;
	}
}
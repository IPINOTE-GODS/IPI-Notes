
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
import IPINoteGods.IPINotes.Service.EtudiantService;


@RestController
@RequestMapping("/etudiants")
@CrossOrigin
public class EtudiantController {
	
	@Autowired
	EtudiantService etudiantService;

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
}
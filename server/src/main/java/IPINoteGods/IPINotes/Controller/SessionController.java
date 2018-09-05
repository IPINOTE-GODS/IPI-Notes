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

import IPINoteGods.IPINotes.Exception.SessionNotFoundException;
import IPINoteGods.IPINotes.Model.Session;
import IPINoteGods.IPINotes.Service.SessionService;

@RestController
@RequestMapping("/session")
@CrossOrigin
public class SessionController {
	
	@Autowired
	SessionService sessionService;

	/**
	 * Renvoie la liste des sessions.
	 *
	 * @return Toutes les sessions
	 */
	@RequestMapping("/all")
	public List<Session> getAll() {	
		List<Session> evaluations = sessionService.findAll();
		return evaluations;
	}
	
	/**
	 * Supprime toutes les sessions.
	 */
	@RequestMapping("/delete/all")
	public void deleteAll() {
		sessionService.deleteAll();
	}
	
	/**
	 * Renvoie une session par son ID.
	 *
	 * @param id l'ID de la session
	 * @return la session correspondant à l'ID
	 */
	@GetMapping("/{id}")
	public Session get(@PathVariable long id) {
		Optional<Session> session = sessionService.getById(id);
		if(!session.isPresent()) {
			throw new SessionNotFoundException("id-"+id);
		}
		return session.get();	 
	}
	
	/**
	 * Crée une nouvelle session
	 *
	 * @param session la session à enregistrer
	 * @return une réponse HTTP Created
	 */
	@PostMapping("/save")
	public ResponseEntity<Object> create(@RequestBody Session session) {
		Session savedSession = sessionService.save(session);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(savedSession.getAnnee()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}

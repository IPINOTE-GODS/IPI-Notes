package IPINoteGods.IPINotes.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import IPINoteGods.IPINotes.Model.Personne;
import IPINoteGods.IPINotes.Service.EnseignantService;
import IPINoteGods.IPINotes.Service.EtudiantService;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin
public class LoginController {
	
	@Autowired
	EtudiantService etudiantService;
	
	@Autowired
	EnseignantService enseignantService;

	@RequestMapping(value="", method=RequestMethod.POST, consumes="application/json")
	public String get(@RequestBody Map<String, String> authInfo) {
		String username = authInfo.get("username");
		String password = authInfo.get("password");
		
		Optional<Personne> personne = enseignantService.getByUsername(username);// try first to find amongst enseignants
		String type = "enseignant";
		if(!personne.isPresent()) {
			
			personne = etudiantService.getByUsername(username);// if not, check if it's an étudiant
			type = "etudiant";
			
			if(!personne.isPresent()) {
				//throw new UserNotFoundException("Cette utilisateur n'éxiste pas: "+username);
				return "false";
			}
		}
		
		Personne user = personne.get();
		
		if(user.getPassword().equals(password)) {
			return "{"
					+ "\"userType\":\""+type+"\","
					+ "\"id\":\""+user.getId()+"\""
				+ "}";
		} else {
			return "false";
		}
	}
}

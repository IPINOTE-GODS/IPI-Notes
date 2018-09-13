package IPINoteGods.IPINotes.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import IPINoteGods.IPINotes.Exception.UserNotFoundException;
import IPINoteGods.IPINotes.Model.Personne;
import IPINoteGods.IPINotes.Service.PersonneService;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin
public class LoginController {
	
	@Autowired
	PersonneService personneService;

	@RequestMapping(value="", method=RequestMethod.POST, consumes="application/json")
	public boolean get(@RequestBody Map<String, String> authInfo) {
		String username = authInfo.get("username");
		String password = authInfo.get("password");
		
		Optional<Personne> personne = personneService.getByUsername(username);
		if(!personne.isPresent()) {
			//throw new UserNotFoundException("Cette utilisateur n'éxiste pas: "+username);
			return false;
		}
		
		Personne user = personne.get();
		if(user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}

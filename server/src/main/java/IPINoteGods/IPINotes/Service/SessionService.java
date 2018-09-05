package IPINoteGods.IPINotes.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import IPINoteGods.IPINotes.Model.Session;

import IPINoteGods.IPINotes.Repository.SessionRepository;

@Service
public class SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}
	
	public Session save(Session e) {
		return sessionRepository.save(e);
	}

	public void deleteAll() {
		sessionRepository.deleteAll();		
	}

	public void delete(long id) {
		sessionRepository.deleteById(id);
	}

	public Optional<Session> getById(long id) {
		return sessionRepository.findById(id);
	}
}
	
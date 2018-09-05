package IPINoteGods.IPINotes.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IPINoteGods.IPINotes.Model.Module;
import IPINoteGods.IPINotes.Repository.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;
	
	public List<Module> findAll() {
		return moduleRepository.findAll();
	}
	
	public Module save(Module e) {
		return moduleRepository.save(e);
	}

	public void deleteAll() {
		moduleRepository.deleteAll();		
	}

	public void delete(long id) {
		moduleRepository.deleteById(id);
	}

	public Optional<Module> getById(long id) {
		return moduleRepository.findById(id);
	}
}
	
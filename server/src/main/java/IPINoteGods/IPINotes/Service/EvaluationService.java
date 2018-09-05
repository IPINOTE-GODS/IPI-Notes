package IPINoteGods.IPINotes.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IPINoteGods.IPINotes.Model.Evaluation;
import IPINoteGods.IPINotes.Repository.EvaluationRepository;

@Service
public class EvaluationService {

	@Autowired
	private EvaluationRepository evaluationRepository;
	
	public List<Evaluation> findAll() {
		return evaluationRepository.findAll();
	}
	
	public Evaluation save(Evaluation e) {
		return evaluationRepository.save(e);
	}

	public void deleteAll() {
		evaluationRepository.deleteAll();		
	}

	public void delete(long id) {
		evaluationRepository.deleteById(id);
	}

	public Optional<Evaluation> getById(long id) {
		return evaluationRepository.findById(id);
	}
}
	
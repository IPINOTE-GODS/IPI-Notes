package IPINoteGods.IPINotes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IPINoteGods.IPINotes.Model.Formation;
import IPINoteGods.IPINotes.Model.Module;
import IPINoteGods.IPINotes.Model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

	List<Session> findByAnnee(int annee);
	List<Session> findBySessionIdFormation(Formation formation);
	List<Session> findBySessionIdFormationAndSessionIdModule(Formation formation, Module module);
}

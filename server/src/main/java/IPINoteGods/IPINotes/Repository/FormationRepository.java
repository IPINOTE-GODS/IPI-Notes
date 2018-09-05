package IPINoteGods.IPINotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IPINoteGods.IPINotes.Model.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
}

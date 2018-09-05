package IPINoteGods.IPINotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IPINoteGods.IPINotes.Model.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}

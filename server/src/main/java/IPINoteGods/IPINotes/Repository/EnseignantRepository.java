package IPINoteGods.IPINotes.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IPINoteGods.IPINotes.Model.Enseignant;
import IPINoteGods.IPINotes.Model.Personne;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

	Optional<Personne> findByNom(String username);
}

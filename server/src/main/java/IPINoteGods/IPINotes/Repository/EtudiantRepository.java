package IPINoteGods.IPINotes.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IPINoteGods.IPINotes.Model.Etudiant;
import IPINoteGods.IPINotes.Model.Personne;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	Optional<Personne> findByNom(String username);
}

package IPINoteGods.IPINotes.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IPINoteGods.IPINotes.Model.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	
	public Optional<Personne> findByNom(String nom);
	
}
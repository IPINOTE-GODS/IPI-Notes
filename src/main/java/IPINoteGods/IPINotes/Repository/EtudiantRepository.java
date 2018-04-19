package IPINoteGods.IPINotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IPINoteGods.IPINotes.Model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}

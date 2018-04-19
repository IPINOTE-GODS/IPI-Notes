package IPINoteGods.IPINotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import IPINoteGods.IPINotes.Model.Etudiant;

@CrossOrigin(origins = "http://localhost:4200")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}

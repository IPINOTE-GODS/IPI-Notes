package IPINoteGods.IPINotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IPINoteGods.IPINotes.Model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}

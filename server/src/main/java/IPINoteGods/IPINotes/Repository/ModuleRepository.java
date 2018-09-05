package IPINoteGods.IPINotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IPINoteGods.IPINotes.Model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}

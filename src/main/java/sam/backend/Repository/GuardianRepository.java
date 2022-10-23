package sam.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.backend.Entity.Guardian;

public interface GuardianRepository extends JpaRepository<Guardian,Long> {
}

package sam.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.backend.Entity.EnrolmentOfficer;

public interface EnrolmentOfficerRepository extends JpaRepository<EnrolmentOfficer,Long> {
}

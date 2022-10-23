package sam.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.backend.Entity.MotherDetails;

public interface MotherDetailsRepository extends JpaRepository<MotherDetails,Long> {
}

package sam.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.backend.Entity.FatherDetails;

public interface FatherDetailsRepository extends JpaRepository<FatherDetails,Long> {
}

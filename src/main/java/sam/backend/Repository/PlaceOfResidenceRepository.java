package sam.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.backend.Entity.PlaceOfResidence;

public interface PlaceOfResidenceRepository extends JpaRepository<PlaceOfResidence,Long> {
}

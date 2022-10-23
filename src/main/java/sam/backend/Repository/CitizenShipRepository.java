package sam.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.backend.Entity.CitizenShip;

public interface CitizenShipRepository extends JpaRepository<CitizenShip,Long> {
}

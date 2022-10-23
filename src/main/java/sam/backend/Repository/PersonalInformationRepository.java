package sam.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.backend.Entity.PersonalInformation;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation,Long> {
}

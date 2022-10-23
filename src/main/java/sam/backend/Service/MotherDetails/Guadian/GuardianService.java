package sam.backend.Service.MotherDetails.Guadian;

import sam.backend.Entity.Guardian;
import sam.backend.Entity.PersonalInformation;

import java.util.List;

public interface GuardianService {
    Guardian saveGuardian(Guardian guardian);
    List<Guardian> getAllGuardian();
    Guardian getGuardianById(long id);
    Guardian updateGuardian(Guardian guardian, long id);
    void deleteGuardian(long id);


}

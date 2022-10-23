package sam.backend.Service.MotherDetails;

import sam.backend.Entity.CitizenShip;
import sam.backend.Entity.MotherDetails;

import java.util.List;

public interface MotherDetailsService {
    MotherDetails saveMotherDetails(MotherDetails motherDetails);

    List<MotherDetails> getAllMotherDetails();

    MotherDetails getMotherDetailsById(long id);

    MotherDetails updateMotherDetails(MotherDetails motherDetails, long id);

    void deleteMotherDetails(long id);
}


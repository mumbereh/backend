package sam.backend.Service.SpouseDetails;



import sam.backend.Entity.SpouseDetails;

import java.util.List;

public interface SpouseDetailsService {
    SpouseDetails saveSpouseDetails(SpouseDetails spouseDetails);
    List<SpouseDetails> getAllSpouseDetails();
    SpouseDetails getSpouseDetailsById(long id);
    SpouseDetails updateSpouseDetails(SpouseDetails spouseDetails, long id);
    void deleteSpouseDetails(long id);




}


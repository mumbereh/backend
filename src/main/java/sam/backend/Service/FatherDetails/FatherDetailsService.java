package sam.backend.Service.FatherDetails;

import sam.backend.Entity.FatherDetails;


import java.util.List;

public interface FatherDetailsService {
    FatherDetails saveFatherDetails(FatherDetails fatherDetails);
    List<FatherDetails> getAllFatherDetails();
    FatherDetails getFatherDetailsById(long id);
    FatherDetails updateFatherDetails(FatherDetails fatherDetails, long id);
    void deleteFatherDetails(long id);

}

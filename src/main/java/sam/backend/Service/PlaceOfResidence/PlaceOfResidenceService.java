package sam.backend.Service.PlaceOfResidence;



import sam.backend.Entity.PlaceOfResidence;

import java.util.List;

public interface PlaceOfResidenceService {
    PlaceOfResidence savePlaceOfResidence(PlaceOfResidence placeOfResidence);

    List<PlaceOfResidence> getAllPlaceOfResidence();

    PlaceOfResidence getPlaceOfResidenceById(long id);

    PlaceOfResidence updatePlaceOfResidence(PlaceOfResidence placeOfResidence, long id);

    void deletePlaceOfResidence(long id);

}

package sam.backend.Service.PlaceOfOrigin;



import sam.backend.Entity.PlaceOfOrigin;


import java.util.List;

public interface PlaceOfOriginService {
    PlaceOfOrigin savePlaceOfOrigin(PlaceOfOrigin placeOfOrigin);

    List<PlaceOfOrigin> getAllPlaceOfOrigin();

    PlaceOfOrigin getPlaceOfOriginById(long id);

    PlaceOfOrigin updatePlaceOfOrigin(PlaceOfOrigin placeOfOrigin, long id);

    void deletePlaceOfOrigin(long id);

}

package sam.backend.Service.PlaceOfOrigin;

import org.springframework.stereotype.Service;
import sam.backend.Entity.PlaceOfOrigin;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.PlaceOfOriginRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PlaceOfOriginServiceImp implements PlaceOfOriginService {

    private PlaceOfOriginRepository placeOfOriginRepository;

    public PlaceOfOriginServiceImp(PlaceOfOriginRepository placeOfOriginRepository) {
        this.placeOfOriginRepository = placeOfOriginRepository;
    }


    @Override
    public PlaceOfOrigin savePlaceOfOrigin(PlaceOfOrigin placeOfOrigin) {
        return placeOfOriginRepository.save(placeOfOrigin);
    }

    @Override
    public List<PlaceOfOrigin> getAllPlaceOfOrigin() {
        return placeOfOriginRepository.findAll();
    }

    @Override
    public PlaceOfOrigin getPlaceOfOriginById(long id) {
        Optional<PlaceOfOrigin> PlaceOfOrigin = placeOfOriginRepository.findById(id);
        if (PlaceOfOrigin.isPresent()) {
            return PlaceOfOrigin.get();
        } else {
            throw new ResourceNotFoundException("PlaceOfOrigin", "Id", id);
        }
    }

    @Override
    public PlaceOfOrigin updatePlaceOfOrigin(PlaceOfOrigin placeOfOrigin, long id) {
        PlaceOfOrigin existingPlaceOfOrigin = placeOfOriginRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recommender", "Id", id));
        existingPlaceOfOrigin.setVillage(placeOfOrigin.getVillage());
        existingPlaceOfOrigin.setParish(placeOfOrigin.getCountry());
        existingPlaceOfOrigin.setSub_county(placeOfOrigin.getSub_county());
        existingPlaceOfOrigin.setCounty(placeOfOrigin.getCounty());
        existingPlaceOfOrigin.setDistrict(placeOfOrigin.getDistrict());
        existingPlaceOfOrigin.setCountry(placeOfOrigin.getCountry());
        existingPlaceOfOrigin.setStreet(placeOfOrigin.getStreet());
        return existingPlaceOfOrigin;
    }

    @Override
    public void deletePlaceOfOrigin(long id) {
        placeOfOriginRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("PlaceOfOrigin", "Id", id));
        placeOfOriginRepository.deleteById(id);


    }
}



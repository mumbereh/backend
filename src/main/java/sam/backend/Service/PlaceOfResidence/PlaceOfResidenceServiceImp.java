package sam.backend.Service.PlaceOfResidence;

import org.springframework.stereotype.Service;
import sam.backend.Entity.PlaceOfResidence;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.PlaceOfResidenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceOfResidenceServiceImp implements PlaceOfResidenceService {
    private PlaceOfResidenceRepository placeOfResidenceRepository;

    public PlaceOfResidenceServiceImp(PlaceOfResidenceRepository placeOfResidenceRepository) {
        this.placeOfResidenceRepository = placeOfResidenceRepository;
    }


    @Override
    public PlaceOfResidence savePlaceOfResidence(PlaceOfResidence placeOfResidence) {
        return placeOfResidenceRepository.save(placeOfResidence);
    }

    @Override
    public List<PlaceOfResidence> getAllPlaceOfResidence() {

        return placeOfResidenceRepository.findAll();
    }

    @Override
    public PlaceOfResidence getPlaceOfResidenceById(long id) {
        Optional<PlaceOfResidence> PlaceOfResidence = placeOfResidenceRepository.findById(id);
        if (PlaceOfResidence.isPresent()) {
            return PlaceOfResidence.get();
        } else {
            throw new ResourceNotFoundException("PlaceOfResidence", "Id", id);
        }
    }

    @Override
    public PlaceOfResidence updatePlaceOfResidence(PlaceOfResidence placeOfResidence, long id) {
        PlaceOfResidence existingPlaceOfResidence = placeOfResidenceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PlaceOfResidence", "Id", id));
        existingPlaceOfResidence.setVillage(placeOfResidence.getVillage());
        existingPlaceOfResidence.setParish(placeOfResidence.getParish());
        existingPlaceOfResidence.setSub_county(placeOfResidence.getSub_county());
        existingPlaceOfResidence.setCounty(placeOfResidence.getCounty());
        existingPlaceOfResidence.setDistrict(placeOfResidence.getDistrict());
        existingPlaceOfResidence.setCountry(placeOfResidence.getCountry());
        existingPlaceOfResidence.setStreet(placeOfResidence.getStreet());
        existingPlaceOfResidence.setPlotNo(placeOfResidence.getPlotNo());



        return existingPlaceOfResidence;
    }

    @Override
    public void deletePlaceOfResidence(long id) {
        placeOfResidenceRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("PlaceOfResidence", "Id", id));
        placeOfResidenceRepository.deleteById(id);

    }
}
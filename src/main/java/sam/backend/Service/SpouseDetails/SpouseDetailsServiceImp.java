package sam.backend.Service.SpouseDetails;

import org.springframework.stereotype.Service;
import sam.backend.Entity.SpouseDetails;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.SpouseDetailsRepository;


import java.util.List;
import java.util.Optional;

@Service
public class SpouseDetailsServiceImp implements SpouseDetailsService {
    private SpouseDetailsRepository spouseDetailsRepository;

    public SpouseDetailsServiceImp(SpouseDetailsRepository spouseDetailsRepository) {
        this.spouseDetailsRepository = spouseDetailsRepository;
    }

    @Override
    public SpouseDetails saveSpouseDetails(SpouseDetails spouseDetails) {
        return spouseDetailsRepository.save(spouseDetails);
    }

    @Override
    public List<SpouseDetails> getAllSpouseDetails() {
        return spouseDetailsRepository.findAll();

    }

    @Override
    public SpouseDetails getSpouseDetailsById(long id) {
        Optional<SpouseDetails> spouseDetails = spouseDetailsRepository.findById(id);
        if (spouseDetails.isPresent()) {
            return spouseDetails.get();
        } else {
            throw new ResourceNotFoundException("PersonalInformation", "Id", id);
        }
    }

    @Override
    public SpouseDetails updateSpouseDetails(SpouseDetails spouseDetails, long id) {
        SpouseDetails existingSpouseDetails = spouseDetailsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PersonalInformation", "Id", id));
        existingSpouseDetails.setSurName(existingSpouseDetails.getSurName());
        existingSpouseDetails.setGivenName(existingSpouseDetails.getGivenName());
        existingSpouseDetails.setOtherName(existingSpouseDetails.getOtherName());
        existingSpouseDetails.setMaidenName(existingSpouseDetails.getMaidenName());
        existingSpouseDetails.setTypeOfMarriage(existingSpouseDetails.getTypeOfMarriage());
        existingSpouseDetails.setDateOfMarriage(existingSpouseDetails.getDateOfMarriage());
        existingSpouseDetails.setPlaceOfMarriage(existingSpouseDetails.getPlaceOfMarriage());
        return existingSpouseDetails;
    }

    @Override
    public void deleteSpouseDetails(long id) {
        spouseDetailsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("SpouseDetails", "Id", id));
        spouseDetailsRepository.deleteById(id);

    }
}
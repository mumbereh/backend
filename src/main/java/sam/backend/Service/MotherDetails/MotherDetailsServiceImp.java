package sam.backend.Service.MotherDetails;

import org.springframework.stereotype.Service;
import sam.backend.Entity.MotherDetails;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.MotherDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MotherDetailsServiceImp implements MotherDetailsService {
    private MotherDetailsRepository motherDetailsRepository;

    public MotherDetailsServiceImp(MotherDetailsRepository motherDetailsRepository) {
        this.motherDetailsRepository = motherDetailsRepository;
    }

    @Override
    public MotherDetails saveMotherDetails(MotherDetails motherDetails){
        return motherDetailsRepository.save(motherDetails);
    }

    @Override
    public List<MotherDetails> getAllMotherDetails() {
        return motherDetailsRepository.findAll();

    }

    @Override
    public MotherDetails getMotherDetailsById(long id) {
        Optional<MotherDetails> motherDetails = motherDetailsRepository.findById(id);
        if (motherDetails.isPresent()) {
            return motherDetails.get();
        } else {
            throw new ResourceNotFoundException("PersonalInformation", "Id", id);
        }

    }

    @Override
    public MotherDetails updateMotherDetails(MotherDetails motherDetails, long id) {
        MotherDetails existingMotherDetails = motherDetailsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PersonalInformation", "Id", id));
        existingMotherDetails.setVillage(motherDetails.getVillage());
        existingMotherDetails.setParish(motherDetails.getParish());
        existingMotherDetails.setSub_county(motherDetails.getSub_county());
        existingMotherDetails.setCounty(motherDetails.getCounty());
        existingMotherDetails.setDistrict(motherDetails.getDistrict());
        existingMotherDetails.setCountry(motherDetails.getCountry());
        existingMotherDetails.setTribe(motherDetails.getTribe());
        existingMotherDetails.setClan(motherDetails.getClan());
        return existingMotherDetails;
    }

    @Override
    public void deleteMotherDetails(long id) {
        motherDetailsRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("MotherDetails","Id",id));
        motherDetailsRepository.deleteById(id);


    }
}
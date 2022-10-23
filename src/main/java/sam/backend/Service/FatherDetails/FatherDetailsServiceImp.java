package sam.backend.Service.FatherDetails;

import org.springframework.stereotype.Service;
import sam.backend.Entity.FatherDetails;
import sam.backend.Entity.PersonalInformation;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.FatherDetailsRepository;
import sam.backend.Repository.PersonalInformationRepository;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.Optional;


@Service
public class FatherDetailsServiceImp implements FatherDetailsService{
    private FatherDetailsRepository fatherDetailsRepository;

    public FatherDetailsServiceImp(FatherDetailsRepository fatherDetailsRepository) {
        this.fatherDetailsRepository = fatherDetailsRepository;
    }

    @Override
    public FatherDetails saveFatherDetails(FatherDetails fatherDetails) {
        return fatherDetailsRepository.save(fatherDetails);
    }

    @Override
    public List<FatherDetails> getAllFatherDetails() {
        return fatherDetailsRepository.findAll();
    }

    @Override
    public FatherDetails getFatherDetailsById(long id) {
        Optional<FatherDetails> fatherDetails = fatherDetailsRepository.findById(id);
        if (fatherDetails.isPresent()) {
            return fatherDetails.get();
        } else {
            throw new ResourceNotFoundException("PersonalInformation", "Id", id);
        }

    }

    @Override
    public FatherDetails updateFatherDetails(FatherDetails fatherDetails, long id) {
        FatherDetails existingFatherDetails = fatherDetailsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("FatherDetails", "Id", id));
        existingFatherDetails.setFirstName(fatherDetails.getFirstName());
        existingFatherDetails.setLastName(fatherDetails.getLastName());
        existingFatherDetails.setVillage(fatherDetails.getVillage());
        existingFatherDetails.setParish(fatherDetails.getParish());
        existingFatherDetails.setSub_county(fatherDetails.getSub_county());
        existingFatherDetails.setCounty(fatherDetails.getCounty());
        existingFatherDetails.setDistrict(fatherDetails.getDistrict());
        existingFatherDetails.setCountry(fatherDetails.getCountry());
        existingFatherDetails.setStreet(fatherDetails.getStreet());
        existingFatherDetails.setPlotNo(fatherDetails.getPlotNo());
        existingFatherDetails.setPhoneNumber(fatherDetails.getPhoneNumber());
        existingFatherDetails.setLivingStatus(fatherDetails.getLivingStatus());

        return existingFatherDetails;
    }

    @Override
    public void deleteFatherDetails(long id) {
        fatherDetailsRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("FatherDetails","Id",id));
        fatherDetailsRepository.deleteById(id);


    }
}

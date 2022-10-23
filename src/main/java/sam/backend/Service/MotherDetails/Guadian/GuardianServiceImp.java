package sam.backend.Service.MotherDetails.Guadian;

import org.springframework.stereotype.Service;
import sam.backend.Entity.Guardian;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.GuardianRepository;


import java.util.List;
import java.util.Optional;

@Service
public class GuardianServiceImp implements GuardianService{
    private GuardianRepository guardianRepository;

    public GuardianServiceImp(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    @Override
    public Guardian saveGuardian(Guardian guardian) {
        return guardianRepository.save(guardian);
    }

    @Override
    public List<Guardian> getAllGuardian() {
        return guardianRepository.findAll();

    }

    @Override
    public Guardian getGuardianById(long id) {
        Optional<Guardian> guardian = guardianRepository.findById(id);
        if (guardian.isPresent()) {
            return guardian.get();
        } else {
            throw new ResourceNotFoundException("Guardian", "Id", id);
        }

    }

    @Override
    public Guardian updateGuardian(Guardian Guardian, long id) {
        Guardian existingGuardian = guardianRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PersonalInformation", "Id", id));
        existingGuardian.setFirstName(existingGuardian.getFirstName());
        existingGuardian.setLastName(existingGuardian.getLastName());
        existingGuardian.setOtherName(existingGuardian.getOtherName());
        existingGuardian.setTribe(existingGuardian.getTribe());
        existingGuardian.setClan(existingGuardian.getClan());
        existingGuardian.setVillage(existingGuardian.getVillage());
        existingGuardian.setParish(existingGuardian.getParish());
        existingGuardian.setSub_county(existingGuardian.getSub_county());
        existingGuardian.setCounty(existingGuardian.getCounty());
        existingGuardian.setDistrict(existingGuardian.getDistrict());
        existingGuardian.setCountry(existingGuardian.getCountry());
        existingGuardian.setStreet(existingGuardian.getStreet());
        existingGuardian.setPlotNo(existingGuardian.getPlotNo());
        existingGuardian.setPhoneNumber(existingGuardian.getPhoneNumber());
        return existingGuardian;
    }

    @Override
    public void deleteGuardian(long id) {
        guardianRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("Guardian","Id",id));
        guardianRepository.deleteById(id);


    }

}

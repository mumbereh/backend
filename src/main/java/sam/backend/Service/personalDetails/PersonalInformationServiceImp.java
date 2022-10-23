package sam.backend.Service.personalDetails;

import org.springframework.stereotype.Service;
import sam.backend.Entity.PersonalInformation;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.PersonalInformationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationServiceImp implements PersonalInformationService {
    private PersonalInformationRepository personalInformationRepository;

    public PersonalInformationServiceImp(PersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }


    @Override
    public PersonalInformation savePersonalInformation(PersonalInformation personalInformation) {
        return personalInformationRepository.save(personalInformation);
    }

    @Override
    public List<PersonalInformation> getAllPersonalInformation() {
        return personalInformationRepository.findAll();

    }

    @Override
    public PersonalInformation getPersonalInformationById(long id) {
        Optional<PersonalInformation> personalInformation = personalInformationRepository.findById(id);
        if (personalInformation.isPresent()) {
            return personalInformation.get();
        } else {
            throw new ResourceNotFoundException("PersonalInformation", "Id", id);
        }

    }

    @Override
    public PersonalInformation updatePersonalInformation(PersonalInformation personalInformation, long id) {
        PersonalInformation existingPersonalInformation = personalInformationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PersonalInformation", "Id", id));
        existingPersonalInformation.setFirstName(personalInformation.getFirstName());
        existingPersonalInformation.setLastName(personalInformation.getLastName());
        existingPersonalInformation.setOtherName(personalInformation.getOtherName());
        existingPersonalInformation.setEmail(personalInformation.getEmail());
        existingPersonalInformation.setClan(personalInformation.getClan());
        existingPersonalInformation.setMaritalStatus(personalInformation.getMaritalStatus());
        existingPersonalInformation.setDateOfBirth(personalInformation.getDateOfBirth());
        existingPersonalInformation.setPhoneNumber(personalInformation.getPhoneNumber());
        existingPersonalInformation.setProfessional(personalInformation.getProfessional());
        existingPersonalInformation.setLevelOfEducation(personalInformation.getLevelOfEducation());
        existingPersonalInformation.setTribe(personalInformation.getTribe());
        existingPersonalInformation.setReligion(personalInformation.getReligion());
        existingPersonalInformation.setNumberOfDependants(personalInformation.getNumberOfDependants());
        personalInformationRepository.save(existingPersonalInformation);
        return existingPersonalInformation;
    }

    @Override
  public void deletePersonalInformation(long id) {
        personalInformationRepository.findById(id).orElseThrow(()
                                                     ->new ResourceNotFoundException("PersonalInformationRepository","Id",id));
        personalInformationRepository.deleteById(id);


    }
}
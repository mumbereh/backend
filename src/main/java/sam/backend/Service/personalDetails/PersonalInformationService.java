package sam.backend.Service.personalDetails;

import sam.backend.Entity.PersonalInformation;

import java.util.List;

public interface PersonalInformationService {
    PersonalInformation savePersonalInformation( PersonalInformation personalInformation);
    List<PersonalInformation> getAllPersonalInformation();
    PersonalInformation getPersonalInformationById(long id);
    PersonalInformation updatePersonalInformation(PersonalInformation personalInformation, long id);
    void deletePersonalInformation(long id);




}

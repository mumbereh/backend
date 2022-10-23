package sam.backend.Service.EnrolmentOfficer;

import sam.backend.Entity.EnrolmentOfficer;


import java.util.List;

public interface EnrolmentOfficerService {
    EnrolmentOfficer saveEnrolmentOfficer(EnrolmentOfficer enrolmentOfficer);
    List<EnrolmentOfficer> getAllEnrolmentOfficer();
    EnrolmentOfficer getEnrolmentOfficerById(long id);
    EnrolmentOfficer updateEnrolmentOfficer(EnrolmentOfficer enrolmentOfficer, long id);
    void deleteEnrolmentOfficer(long id);

}

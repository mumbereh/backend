package sam.backend.Service.EnrolmentOfficer;

import org.springframework.stereotype.Service;
import sam.backend.Entity.EnrolmentOfficer;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.EnrolmentOfficerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnrolmentOfficerServiceImpl implements EnrolmentOfficerService {
    private EnrolmentOfficerRepository enrolmentOfficerRepository;

    public EnrolmentOfficerServiceImpl(EnrolmentOfficerRepository enrolmentOfficerRepository) {
        this.enrolmentOfficerRepository = enrolmentOfficerRepository;
    }

    @Override
    public EnrolmentOfficer saveEnrolmentOfficer(EnrolmentOfficer enrolmentOfficer) {
        return enrolmentOfficerRepository.save(enrolmentOfficer);
    }

    @Override
    public List<EnrolmentOfficer> getAllEnrolmentOfficer() {
        return enrolmentOfficerRepository.findAll();

    }

    @Override
    public EnrolmentOfficer getEnrolmentOfficerById(long id) {
        Optional<EnrolmentOfficer> enrolmentOfficer = enrolmentOfficerRepository.findById(id);
        if (enrolmentOfficer.isPresent()) {
            return enrolmentOfficer.get();
        } else {
            throw new ResourceNotFoundException("EnrolmentOfficer", "Id", id);
        }

    }
        @Override
        public EnrolmentOfficer updateEnrolmentOfficer (EnrolmentOfficer enrolmentOfficer,long id){
            EnrolmentOfficer existingEnrolmentOfficer = enrolmentOfficerRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("EnrolmentOfficer", "Id", id));
            existingEnrolmentOfficer.setFirstName(enrolmentOfficer.getFirstName());
            existingEnrolmentOfficer.setLastName(enrolmentOfficer.getLastName());
            existingEnrolmentOfficer.setNin(existingEnrolmentOfficer.getNin());
            existingEnrolmentOfficer.setCardNo(enrolmentOfficer.getCardNo());
            existingEnrolmentOfficer.setPhoneNumber(enrolmentOfficer.getPhoneNumber());
            return existingEnrolmentOfficer;
        }

        @Override
        public void deleteEnrolmentOfficer ( long id){
            enrolmentOfficerRepository.findById(id).orElseThrow(()
                    -> new ResourceNotFoundException("enrolmentOfficerRepository", "Id", id));
            enrolmentOfficerRepository.findById(id);
        }
    }

package sam.backend.Service.CitizenShip;

import org.springframework.stereotype.Service;
import sam.backend.Entity.CitizenShip;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.CitizenShipRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenShipServiceImp implements CitizenShipService {

    private CitizenShipRepository citizenShipRepository;

    public CitizenShipServiceImp(CitizenShipRepository citizenShipRepository) {
        this.citizenShipRepository = citizenShipRepository;
    }


    @Override
    public CitizenShip saveCitizenShip(CitizenShip citizenShip) {

        return citizenShipRepository.save(citizenShip);
    }

    @Override
    public List<CitizenShip> getAllCitizenShip() {
        return citizenShipRepository.findAll();

    }

    @Override
    public CitizenShip getCitizenShipById(long id) {
        Optional<CitizenShip> citizenShip = citizenShipRepository.findById(id);
        if (citizenShip.isPresent()) {
            return citizenShip.get();
        } else {
            throw new ResourceNotFoundException("citizenShip", "Id", id);
        }
    }
        @Override
        public CitizenShip updateCitizenShip (CitizenShip citizenShip,long id){
            CitizenShip existingCitizenShip = citizenShipRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("CitizenShip", "Id", id));
            existingCitizenShip.setClan(citizenShip.getClan());
            existingCitizenShip.setTribe(citizenShip.getTribe());
            existingCitizenShip.setCitizenshiptype(citizenShip.getCitizenshiptype());
            existingCitizenShip.setCountry(citizenShip.getCountry());
            return existingCitizenShip;

        }
        @Override
        public void deleteCitizenShip ( long id){
            citizenShipRepository.findById(id).orElseThrow(()
                    -> new ResourceNotFoundException("CitizenShip", "Id", id));
            citizenShipRepository.deleteById(id);


        }
    }

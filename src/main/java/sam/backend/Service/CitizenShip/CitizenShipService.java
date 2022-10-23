package sam.backend.Service.CitizenShip;

import sam.backend.Entity.CitizenShip;

import java.util.List;

public interface CitizenShipService {
    CitizenShip saveCitizenShip(CitizenShip citizenShip);

    List<CitizenShip> getAllCitizenShip();

    CitizenShip getCitizenShipById(long id);

    CitizenShip updateCitizenShip(CitizenShip citizenShip, long id);

    void deleteCitizenShip(long id);
}
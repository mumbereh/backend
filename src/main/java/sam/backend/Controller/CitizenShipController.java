package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.CitizenShip;
import sam.backend.Service.CitizenShip.CitizenShipService;


import java.util.List;

@RestController
@RequestMapping("/api/citizenship")
public class CitizenShipController {
    private CitizenShipService citizenShipService;

    public CitizenShipController(CitizenShipService citizenShipService) {
        this.citizenShipService = citizenShipService;
    }

    //creating citizenship REST API
    @PostMapping("/save")
    public ResponseEntity<CitizenShip> saveCitizenShip(@RequestBody CitizenShip citizenShip) {
        return new ResponseEntity<CitizenShip>(citizenShipService.saveCitizenShip(citizenShip), HttpStatus.CREATED);
    }

    //create get ll registered citizenship Rest API
    @GetMapping("all")
    public List<CitizenShip> getAllCitizenShip() {
        return citizenShipService.getAllCitizenShip();
    }

    //Get citizenship by id REST API
    @GetMapping("{id}")
    public ResponseEntity<CitizenShip> getCitizenShipById(@PathVariable("id") long citizenShipId) {
        return new ResponseEntity<CitizenShip>(citizenShipService.getCitizenShipById(citizenShipId), HttpStatus.OK);
    }

    //create update citizenship  REST API
    @PutMapping("{id}")
    public ResponseEntity<CitizenShip> updateCitizenShipById(@PathVariable("id") long id,
                                                             @RequestBody CitizenShip citizenShip) {
        return new ResponseEntity<CitizenShip>(citizenShipService.updateCitizenShip(citizenShip, id), HttpStatus.OK);
    }

    //create citizen delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCitizenShip(@PathVariable("id") long id) {
        //delete citizenship from the DB
        citizenShipService.deleteCitizenShip(id);

        return new ResponseEntity<>("CitizenShip deleted successfully!", HttpStatus.OK);

    }

}
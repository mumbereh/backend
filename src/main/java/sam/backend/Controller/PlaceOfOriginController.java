package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.PersonalInformation;
import sam.backend.Entity.PlaceOfOrigin;
import sam.backend.Service.PlaceOfOrigin.PlaceOfOriginService;
import sam.backend.Service.personalDetails.PersonalInformationService;

import java.util.List;

@RestController
@RequestMapping("/api/place-of-origin")
public class PlaceOfOriginController {
    private PlaceOfOriginService placeOfOriginService;

    public PlaceOfOriginController(PlaceOfOriginService placeOfOriginService) {
        this.placeOfOriginService = placeOfOriginService;
    }
    //creating place of origin REST API
    @PostMapping("/save")
    public ResponseEntity<PlaceOfOrigin> savePlaceOfOrigin(@RequestBody PlaceOfOrigin placeOfOrigin){
        return new ResponseEntity<PlaceOfOrigin>(placeOfOriginService.savePlaceOfOrigin(placeOfOrigin), HttpStatus.CREATED);
    }
    //create get all registered places of origin  Rest API
    @GetMapping("/get-all")
    public List<PlaceOfOrigin> getAllPlaceOfOrigin(){
        return placeOfOriginService.getAllPlaceOfOrigin();
    }
    //Get place of origin  by id REST API
    @GetMapping("{id}")
    public ResponseEntity<PlaceOfOrigin> getPlaceOfOriginById(@PathVariable("id") long placeOfOriginId){
        return  new ResponseEntity<PlaceOfOrigin>(placeOfOriginService.getPlaceOfOriginById(placeOfOriginId),HttpStatus.OK);
    }
    //create update Place of origin REST API
    @PutMapping("{id}")
    public ResponseEntity<PlaceOfOrigin>updatePlaceOfOriginById(@PathVariable("id")long id,
                                                                            @RequestBody PlaceOfOrigin placeOfOrigin){
        return new ResponseEntity<PlaceOfOrigin>(placeOfOriginService.updatePlaceOfOrigin(placeOfOrigin,id),HttpStatus.OK);
    }
    //create delete place of origin  REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deletePlaceOfOrigin(@PathVariable("id")long id){

        //delete place of origin from the DB
        placeOfOriginService.deletePlaceOfOrigin(id);

        return new ResponseEntity<>("PlaceOfOrigin deleted successfully!",HttpStatus.OK);

    }
}


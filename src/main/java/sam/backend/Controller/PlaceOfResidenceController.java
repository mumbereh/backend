package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.PlaceOfResidence;
import sam.backend.Service.PlaceOfResidence.PlaceOfResidenceService;

import java.util.List;

    @RestController
    @RequestMapping("/api/place-of-residence")
    public class PlaceOfResidenceController {
        private PlaceOfResidenceService placeOfResidenceService;

        public PlaceOfResidenceController(PlaceOfResidenceService placeOfResidenceService) {
            this.placeOfResidenceService = placeOfResidenceService;
        }

        //creating add place of residence REST API
        @PostMapping("/add")
        public ResponseEntity<PlaceOfResidence> savePlaceOfResidence(@RequestBody PlaceOfResidence placeOfResidence){
            return new ResponseEntity<PlaceOfResidence>(placeOfResidenceService.savePlaceOfResidence(placeOfResidence), HttpStatus.CREATED);
        }
        //create get all  places of residence  Rest API
        @GetMapping("/get-all")
        public List<PlaceOfResidence> getAllPlaceOfResidence(){
            return placeOfResidenceService.getAllPlaceOfResidence();
        }
        //Get place of residence  by id REST API
        @GetMapping("{id}")
        public ResponseEntity<PlaceOfResidence> getPlaceOfResidenceById(@PathVariable("id") long PlaceOfResidenceId){
            return  new ResponseEntity<PlaceOfResidence>(placeOfResidenceService.getPlaceOfResidenceById(PlaceOfResidenceId),HttpStatus.OK);
        }
        //create update Place of residence REST API
        @PutMapping("{id}")
        public ResponseEntity<PlaceOfResidence>updatePlaceOfResidenceById(@PathVariable("id")long id,
                                                                    @RequestBody PlaceOfResidence placeOfResidence){
            return new ResponseEntity<PlaceOfResidence>(placeOfResidenceService.updatePlaceOfResidence(placeOfResidence,id),HttpStatus.OK);
        }
        //create delete place of origin  REST API
        @DeleteMapping("{id}")
        public ResponseEntity<String>deletePlaceOfResidence(@PathVariable("id")long id){

            //delete place of origin from the DB
            placeOfResidenceService.deletePlaceOfResidence(id);

            return new ResponseEntity<>("Place Of Residence deleted successfully!",HttpStatus.OK);

        }
    }


package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.SpouseDetails;
import sam.backend.Service.SpouseDetails.SpouseDetailsService;


import java.util.List;

@RestController
@RequestMapping("/spouse-detail")
public class SpouseDetailsController{
    private SpouseDetailsService spouseDetailsService;

    public SpouseDetailsController(SpouseDetailsService spouseDetailsService) {
        this.spouseDetailsService = spouseDetailsService;
    }

    //creating spouse details API
    @PostMapping("/spouse-details")
    public ResponseEntity<SpouseDetails> saveSpouseDetails(@RequestBody SpouseDetails spouseDetails){
        return new ResponseEntity<SpouseDetails>(spouseDetailsService.saveSpouseDetails(spouseDetails), HttpStatus.CREATED);
    }
    //create get all spouse details Rest API
    @GetMapping
    public List<SpouseDetails> getAllSpouseDetails(){
        return spouseDetailsService.getAllSpouseDetails();
    }
    //create get spouse details by id REST API
    @GetMapping("{id}")
    public ResponseEntity<SpouseDetails> getSpouseDetailsById(@PathVariable("id") long spouseDetailsId){
        return  new ResponseEntity<SpouseDetails>(spouseDetailsService.getSpouseDetailsById(spouseDetailsId),HttpStatus.OK);
    }
    //create update spouse by id REST API
    @PutMapping("{id}")
    public ResponseEntity<SpouseDetails>updateSpouseDetailsById(@PathVariable("id")long id,
                                                                            @RequestBody SpouseDetails spouseDetails){
        return new ResponseEntity<SpouseDetails>(spouseDetailsService.updateSpouseDetails(spouseDetails,id),HttpStatus.OK);
    }
    //create spouse detail delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteSpouseDetails(@PathVariable("id")long id){
        //delete spouse detail from the DB
        spouseDetailsService.deleteSpouseDetails(id);

        return new ResponseEntity<>("SpouseDetails deleted successfully!",HttpStatus.OK);

    }
}



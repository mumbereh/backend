package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.MotherDetails;
import sam.backend.Service.MotherDetails.MotherDetailsService;


import java.util.List;
@RestController
@RequestMapping("/api/mother")
public class MotherDetailsController {
    private MotherDetailsService motherDetailsService;

    public MotherDetailsController(MotherDetailsService motherDetailsService) {
        this.motherDetailsService = motherDetailsService;
    }

    //create add mother REST API
    @PostMapping("/MotherDetails")
    public ResponseEntity<MotherDetails> saveMotherDetails(@RequestBody MotherDetails motherDetails){
        return new ResponseEntity<MotherDetails>(motherDetailsService.saveMotherDetails(motherDetails), HttpStatus.CREATED);
    }
    //create get all  mothers detail Rest API
    @GetMapping
    public List<MotherDetails> getAllMotherDetails(){
        return motherDetailsService.getAllMotherDetails();
    }
    //create Get mother by id REST API
    @GetMapping("{id}")
    public ResponseEntity<MotherDetails> getMotherDetailsById(@PathVariable("id") long motherDetailsId){
        return  new ResponseEntity<MotherDetails>(motherDetailsService.getMotherDetailsById(motherDetailsId),HttpStatus.OK);
    }
    //create update mother's  details by id  REST API
    @PutMapping("{id}")
    public ResponseEntity<MotherDetails>updateMotherDetailsById(@PathVariable("id")long id,
                                                                            @RequestBody MotherDetails motherDetails){
        return new ResponseEntity<MotherDetails>(motherDetailsService.updateMotherDetails(motherDetails,id),HttpStatus.OK);
    }
    //create delete mother's details delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteMotherDetails(@PathVariable("id")long id){
        //delete mother's details  from the DB
        motherDetailsService.deleteMotherDetails(id);
        return new ResponseEntity<>("MotherDetails deleted successfully!",HttpStatus.OK);

    }
}



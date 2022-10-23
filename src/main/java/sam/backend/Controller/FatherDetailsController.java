package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.FatherDetails;
import sam.backend.Service.FatherDetails.FatherDetailsService;
import java.util.List;


@RestController
@RequestMapping("/api/father")
public class FatherDetailsController {
    private FatherDetailsService fatherDetailsService;

    public FatherDetailsController(FatherDetailsService fatherDetailsService) {
        this.fatherDetailsService = fatherDetailsService;
    }

    //creating add father REST API
    @PostMapping("/add")
    public ResponseEntity<FatherDetails> saveFatherDetails(@RequestBody FatherDetails fatherDetails){
        return new ResponseEntity<FatherDetails>(fatherDetailsService.saveFatherDetails(fatherDetails), HttpStatus.CREATED);
    }
    //create get all registered people Rest API
    @GetMapping("/view")
    public List<FatherDetails> getFatherDetails(){
        return fatherDetailsService.getAllFatherDetails();
    }

    //create get father by id REST API
    @GetMapping("{id}")
    public ResponseEntity<FatherDetails> getFatherDetailsById(@PathVariable("id") long fatherDetailsId){
        return  new ResponseEntity<FatherDetails>(fatherDetailsService.getFatherDetailsById(fatherDetailsId),HttpStatus.OK);
    }
    //create update father by id REST API
    @PutMapping("{id}")
    public ResponseEntity<FatherDetails>updateFatherDetailsById(@PathVariable("id")long id,
                                                                            @RequestBody FatherDetails fatherDetails){
        return new ResponseEntity<FatherDetails>(fatherDetailsService.updateFatherDetails(fatherDetails,id),HttpStatus.OK);
    }
    //create delete father REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteFatherDetails(@PathVariable("id")long id){
        //delete father from the DB
        fatherDetailsService.deleteFatherDetails(id);

        return new ResponseEntity<>("FatherDetails deleted successfully!",HttpStatus.OK);

    }
}



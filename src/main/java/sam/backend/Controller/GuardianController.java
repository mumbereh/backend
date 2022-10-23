package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.Guardian;
import sam.backend.Service.MotherDetails.Guadian.GuardianService;


import java.util.List;

@RestController
@RequestMapping("/api/guardian")
public class GuardianController {

    private GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    //creating add guardian  API
    @PostMapping("/add")
    public ResponseEntity<Guardian> saveGuardian(@RequestBody Guardian guardian){
        return new ResponseEntity<Guardian>(guardianService.saveGuardian(guardian), HttpStatus.CREATED);
    }
    //create get all registered guardian REST API
    @GetMapping("/get-all")
    public List<Guardian> getAllGuardian(){
        return guardianService.getAllGuardian();
    }

    //create Get guardian by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable("id") long guardianId){
        return  new ResponseEntity<Guardian>(guardianService.getGuardianById(guardianId),HttpStatus.OK);
    }
    //create update guardian REST API
    @PutMapping("{id}")
    public ResponseEntity<Guardian>updateGuardianById(@PathVariable("id")long id,
                                                                            @RequestBody Guardian guardian){
        return new ResponseEntity<Guardian>(guardianService.updateGuardian(guardian,id),HttpStatus.OK);
    }
    //create guardian delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteGuardian(@PathVariable("id")long id){
        //delete guardian from the DB
        guardianService.deleteGuardian(id);

        return new ResponseEntity<>("guardian deleted successfully!",HttpStatus.OK);

    }
}



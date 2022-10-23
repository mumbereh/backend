package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.EnrolmentOfficer;;
import sam.backend.Service.EnrolmentOfficer.EnrolmentOfficerService;
import java.util.List;

@RestController
@RequestMapping("/api/officer")
public class EnrolmentOfficerController {
    private EnrolmentOfficerService enrolmentOfficerService;

    public EnrolmentOfficerController(EnrolmentOfficerService enrolmentOfficerService) {
        this.enrolmentOfficerService = enrolmentOfficerService;
    }

    //creating add enrollment officer  REST API
    @PostMapping("/add")
    public ResponseEntity<EnrolmentOfficer> saveEnrolmentOfficer(@RequestBody EnrolmentOfficer enrolmentOfficer){
        return new ResponseEntity<EnrolmentOfficer>(enrolmentOfficerService.saveEnrolmentOfficer(enrolmentOfficer), HttpStatus.CREATED);
    }

    //create get all registered enrollment officer REST API
    @GetMapping
    public List<EnrolmentOfficer> getAllEnrolmentOfficer(){
        return enrolmentOfficerService.getAllEnrolmentOfficer();
    }
    //create get enrollment officer by id REST API
    @GetMapping("{id}")
    public ResponseEntity<EnrolmentOfficer> getEnrolmentOfficerById(@PathVariable("id") long EnrolmentOfficerId){
        return  new ResponseEntity<EnrolmentOfficer>(enrolmentOfficerService.getEnrolmentOfficerById(EnrolmentOfficerId),HttpStatus.OK);
    }
    //create update enrollment officer REST API
    @PutMapping("{id}")
    public ResponseEntity<EnrolmentOfficer>updatePersonalInformationById(@PathVariable("id")long id,
                                                                            @RequestBody EnrolmentOfficer enrolmentOfficer){
        return new ResponseEntity<EnrolmentOfficer>(enrolmentOfficerService.updateEnrolmentOfficer(enrolmentOfficer,id),HttpStatus.OK);
    }
    //create enrollment officer delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deletePersonalInformation(@PathVariable("id")long id){
        //delete enrollment officer from the DB
        enrolmentOfficerService.deleteEnrolmentOfficer(id);

        return new ResponseEntity<>("Enrollment officer deleted successfully!",HttpStatus.OK);

    }
}

package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.PersonalInformation;
import sam.backend.Service.personalDetails.PersonalInformationService;

import java.util.List;

@RestController
@RequestMapping("/api/registration")
public class personalInformationController {
    private PersonalInformationService personalInformationService;

    public personalInformationController(PersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }
    //creating personalInformation API
    @PostMapping("/personalinformation")
    public ResponseEntity<PersonalInformation>  savePersonalInformation(@RequestBody PersonalInformation personalInformation){
return new ResponseEntity<PersonalInformation>(personalInformationService.savePersonalInformation(personalInformation), HttpStatus.CREATED);
    }
//create get all registered people Rest API
    @GetMapping
    public List<PersonalInformation>getAllPersonalInformation(){
        return personalInformationService.getAllPersonalInformation();
    }
    //Get personalInformation by id REST API
    @GetMapping("{id}")
    public ResponseEntity<PersonalInformation> getPersonalInformationById(@PathVariable("id") long personalInformationId){
return  new ResponseEntity<PersonalInformation>(personalInformationService.getPersonalInformationById(personalInformationId),HttpStatus.OK);
    }
//create update PersonalInformation REST
    @PutMapping("{id}")
    public ResponseEntity<PersonalInformation>updatePersonalInformationById(@PathVariable("id")long id,
                                                                            @RequestBody PersonalInformation personalInformation){
        return new ResponseEntity<PersonalInformation>(personalInformationService.updatePersonalInformation(personalInformation,id),HttpStatus.OK);
    }
    //create PersonalInformation delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deletePersonalInformation(@PathVariable("id")long id){
        //delete personalInformation from the DB
        personalInformationService.deletePersonalInformation(id);

        return new ResponseEntity<>("personalInformation deleted successfully!",HttpStatus.OK);

    }
}

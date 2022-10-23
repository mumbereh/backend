package sam.backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.backend.Entity.Recommender;
import sam.backend.Service.Recommender.RecommenderService;


import java.util.List;

public class RecommenderController {
    private RecommenderService recommenderService;

    public RecommenderController(RecommenderService recommenderService) {
        this.recommenderService = recommenderService;
    }

    //creating add Recommender REST API
    @PostMapping("/recommender")
    public ResponseEntity<Recommender> saveRecommender(@RequestBody Recommender recommender){
        return new ResponseEntity<Recommender>(recommenderService.saveRecommender(recommender), HttpStatus.CREATED);
    }
    //create get all Recommender REST API
    @GetMapping
    public List<Recommender> getAllRecommender(){
        return recommenderService.getAllRecommender();
    }

    //create get Recommender by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Recommender> getRecommenderById(@PathVariable("id") long RecommenderId){
        return  new ResponseEntity<Recommender>(recommenderService.getRecommenderById(RecommenderId),HttpStatus.OK);
    }
    //create update Recommender REST API
    @PutMapping("{id}")
    public ResponseEntity<Recommender>updateRecommenderById(@PathVariable("id")long id,
                                                                            @RequestBody Recommender recommender){
        return new ResponseEntity<Recommender>(recommenderService.updateRecommender(recommender,id),HttpStatus.OK);
    }
    //create Recommender delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteRecommender(@PathVariable("id")long id){
        //delete Recommender from the DB
        recommenderService.deleteRecommender(id);

        return new ResponseEntity<>("Recommender deleted successfully!",HttpStatus.OK);

    }
}

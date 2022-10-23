package sam.backend.Service.Recommender;

import sam.backend.Entity.Recommender;
import sam.backend.Exception.ResourceNotFoundException;
import sam.backend.Repository.RecommenderRepository;

import java.util.List;
import java.util.Optional;


public class RecommenderServiceImp implements RecommenderService {
    private RecommenderRepository recommenderRepository;

    public RecommenderServiceImp(RecommenderRepository recommenderRepository) {
        this.recommenderRepository = recommenderRepository;
    }
    @Override
    public Recommender saveRecommender(Recommender recommender) {
        return recommenderRepository.save(recommender);
    }

    @Override
    public List<Recommender> getAllRecommender() {
        return null;
    }

    @Override
    public Recommender getRecommenderById(long id) {
        Optional<Recommender> Recommender = recommenderRepository.findById(id);
        if (Recommender.isPresent()) {
            return Recommender.get();
        } else {
            throw new ResourceNotFoundException("PersonalInformation", "Id", id);
        }
    }

    @Override
    public Recommender updateRecommender(Recommender recommender, long id) {
    Recommender existingRecommender = recommenderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recommender", "Id", id));
        existingRecommender.setFirstName(existingRecommender.getFirstName());
        existingRecommender.setLastName(existingRecommender.getLastName());
        existingRecommender.setNin(existingRecommender.getNin());
        existingRecommender.setCardNo(existingRecommender.getCardNo());
        existingRecommender.setPhoneNumber(existingRecommender.getPhoneNumber());
        existingRecommender.setDesignation(existingRecommender.getDesignation());
        recommenderRepository.save(recommender);
       return existingRecommender;
    }

    @Override
    public void deleteRecommender(long id) {
       recommenderRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("recommenderRepository","Id",id));
        recommenderRepository.deleteById(id);

    }
}



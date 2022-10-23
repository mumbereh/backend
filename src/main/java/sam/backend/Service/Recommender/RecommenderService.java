package sam.backend.Service.Recommender;

import org.springframework.stereotype.Service;
import sam.backend.Entity.Recommender;

import java.util.List;
@Service
public interface RecommenderService {

   Recommender saveRecommender(Recommender recommender);
    List<Recommender> getAllRecommender();
    Recommender getRecommenderById(long id);
    Recommender updateRecommender(Recommender recommender, long id);
    void deleteRecommender(long id);

}
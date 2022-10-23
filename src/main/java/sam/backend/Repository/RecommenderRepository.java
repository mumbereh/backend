package sam.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.backend.Entity.Recommender;

public interface RecommenderRepository extends JpaRepository<Recommender,Long> {
}

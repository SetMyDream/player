package media.player.repository;

import media.player.model.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CompositionRepository extends JpaRepository<Composition, String> {
}

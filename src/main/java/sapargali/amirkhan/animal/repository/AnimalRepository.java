package sapargali.amirkhan.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sapargali.amirkhan.animal.model.Animal;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {
}

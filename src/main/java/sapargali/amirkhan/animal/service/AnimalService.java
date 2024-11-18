package sapargali.amirkhan.animal.service;

import sapargali.amirkhan.animal.model.Animal;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnimalService {

    UUID create(Animal animal);

    List<Animal> findAll();

    Animal findById(UUID id);

    void update(UUID id, Animal animal);

    void delete(UUID id);
}

package sapargali.amirkhan.animal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sapargali.amirkhan.animal.model.Animal;
import sapargali.amirkhan.animal.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Transactional
    @Override
    public UUID create(Animal animal) {
        animal.setId(UUID.randomUUID());
        return animalRepository.save(animal).getId();
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findById(UUID id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal with id " + id + " not found."));
    }

    @Transactional
    @Override
    public void update(UUID id,Animal animal) {
        animalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal with id " + id + " not found."));
        animal.setId(id);
        animalRepository.save(animal);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        animalRepository.deleteById(id);
    }
}

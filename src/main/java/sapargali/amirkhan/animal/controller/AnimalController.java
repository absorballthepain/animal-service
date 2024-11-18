package sapargali.amirkhan.animal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sapargali.amirkhan.animal.model.Animal;
import sapargali.amirkhan.animal.service.AnimalService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody Animal animal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.create(animal));
    }

    @GetMapping
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.ok(animalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(animalService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody Animal animal) {
        animalService.update(id, animal);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        animalService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

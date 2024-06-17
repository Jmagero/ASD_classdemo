package miu.edu.cse.springdemotest2.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import miu.edu.cse.springdemotest2.model.Person;
import miu.edu.cse.springdemotest2.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    @GetMapping
    public ResponseEntity<List<Person>> getPersons() {
        Optional<List<Person>> personList = personService.getAllPersons();
        return personList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.getPersonById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) throws URISyntaxException {
        Optional<Person> person1 = personService.savePerson(person);
        if (person1.isPresent()) {
            return ResponseEntity.created(new URI("/persons/" + person1.get().getId()))
                    .body(person1.get());
        }
        return ResponseEntity.badRequest().body(person);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Person> getPersonByUsername(@PathVariable String username) {
        Optional<Person> personOptional = personService.getPersonByName(username);
        return personOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) throws URISyntaxException {
       Optional<Person> updatedPerson = personService.updatePerson(id, person);
        return updatedPerson.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

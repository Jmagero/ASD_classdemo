package miu.edu.cse.springdemotest2.service;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.springdemotest2.model.Person;
import miu.edu.cse.springdemotest2.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PersonServiceImp implements PersonService {
    private final PersonRepository personRepository;
    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Optional<List<Person>> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        if (persons.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(personRepository.findAll());
    }

    @Override
    public Optional<Person> savePerson(Person person) {
        return Optional.of(personRepository.save(person));
    }

    @Override
    public Optional<Person> updatePerson(Long id, Person person) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (foundPerson.isPresent()) {
            foundPerson.get().setPassword(person.getPassword());
            return Optional.of(personRepository.save(foundPerson.get()));
        }
        return Optional.of(personRepository.save(person));
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Optional<Person> getPersonByName(String name) {
        return personRepository.findByUsername(name);
    }
}

package miu.edu.cse.springdemotest2.service;

import miu.edu.cse.springdemotest2.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Optional<Person> getPersonById(Long id);
    Optional<List<Person>> getAllPersons();
    Optional<Person> savePerson(Person person);
    Optional<Person> updatePerson(Long id, Person person);
    void deletePerson(Long id);
    Optional<Person> getPersonByName(String name);
}

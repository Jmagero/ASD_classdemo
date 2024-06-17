package miu.edu.cse.springdemotest2.repository;

import miu.edu.cse.springdemotest2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByUsername(String username);
}

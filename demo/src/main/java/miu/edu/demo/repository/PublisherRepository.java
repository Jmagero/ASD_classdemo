package miu.edu.demo.repository;

import miu.edu.demo.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findPublisherByPublisherName(String name);
}

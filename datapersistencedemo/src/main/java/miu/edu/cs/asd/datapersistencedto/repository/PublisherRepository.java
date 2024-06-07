package miu.edu.cs.asd.datapersistencedto.repository;

import miu.edu.cs.asd.datapersistencedto.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository  extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByPublisherName(String publisherName);
}

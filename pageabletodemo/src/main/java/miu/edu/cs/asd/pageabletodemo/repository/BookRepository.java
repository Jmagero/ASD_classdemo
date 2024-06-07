package miu.edu.cs.asd.pageabletodemo.repository;

import miu.edu.cs.asd.pageabletodemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

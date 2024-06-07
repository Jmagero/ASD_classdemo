package miu.edu.cs.demomongo.repo;

import miu.edu.cs.demomongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository  extends MongoRepository<User, String> {

    Optional<User> findByUsername(String name);

    @Query(value = "{username:  '?0'}")
    Optional<User> findUserBasedOnName(String name);
}

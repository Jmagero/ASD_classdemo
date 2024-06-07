package miu.edu.cs.demomongo.repo;

import miu.edu.cs.demomongo.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    @Query(value = "{account_name:  '?0', account_type:  '?1'}")
    List<Account> findUserAccountBasedOnNameType(String name, String type);
}

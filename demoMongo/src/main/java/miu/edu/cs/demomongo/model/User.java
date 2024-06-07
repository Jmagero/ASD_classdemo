package miu.edu.cs.demomongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    private String id;
    private String username;
    private String password;
    @DBRef
    private List<Account> accounts;

    public User(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
}

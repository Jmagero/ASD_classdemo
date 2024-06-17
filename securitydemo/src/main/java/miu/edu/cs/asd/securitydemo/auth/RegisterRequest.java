package miu.edu.cs.asd.securitydemo.auth;


import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.cs.asd.securitydemo.user.Role;

@Data
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
}

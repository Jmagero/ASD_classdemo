package miu.edu.cs.asd.userdata.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "username can not be blank")
    private String username;
    @Size(min = 5, max = 16)
    private String password;

    public UserRequestDto(String username, String password) {

        this.username = username;
        this.password = password;
    }
}

package miu.edu.cs.asd.userdata.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDto {
    private String username;
    private String password;

    public UserResponseDto(String username) {
        this.username = username;
    }

}

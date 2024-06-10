package miu.edu.cs.asd.userdata;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.userdata.dto.request.UserRequestDto;
import miu.edu.cs.asd.userdata.dto.response.UserResponseDto;
import miu.edu.cs.asd.userdata.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class UserdataApplication  implements CommandLineRunner {
    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserdataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto("admin", "12345678");
        System.out.println(
                userService.addUser(userRequestDto) + "is saved"
        );
        userRequestDto.setPassword("1235qsd");
//        UserRequestDto userRequestDto2 = new UserRequestDto("admin", "12345677");
        System.out.println( userService.updatePassword("admin", userRequestDto) + "is updated");

    }
}

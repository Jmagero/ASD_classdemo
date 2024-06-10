package miu.edu.cs.asd.userdata.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.userdata.dto.request.UserRequestDto;
import miu.edu.cs.asd.userdata.dto.response.UserResponseDto;
import miu.edu.cs.asd.userdata.exceptional.user.UserNotFoundExceptional;
import miu.edu.cs.asd.userdata.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        Optional<UserResponseDto> responseDto   = userService.addUser(userRequestDto);
        if (responseDto.isPresent()){
            return ResponseEntity.ok(responseDto.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        Optional<List<UserResponseDto>> userResponseDtoList = userService.getAllUsers();
        if (userResponseDtoList.isPresent()){
            return ResponseEntity.ok(userResponseDtoList.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String username) {
        Optional<UserResponseDto> userResponseDto = userService.findByUsername(username);
        if (userResponseDto.isPresent()){
            return ResponseEntity.ok(userResponseDto.get());
        }
        throw new UserNotFoundExceptional(username + " not found");
        //return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{username}")
    public ResponseEntity<UserResponseDto> updatePassword(@PathVariable  String username, @Valid @RequestBody UserRequestDto userRequestDto) {
        Optional<UserResponseDto> userResponseDto = userService.updatePassword(username, userRequestDto);
        if (userResponseDto.isPresent()){
            return ResponseEntity.ok(userResponseDto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserResponseDto> updateUsername(@PathVariable String username,  @Valid @RequestBody UserRequestDto userRequestDto) {
        Optional<UserResponseDto> userResponseDto = userService.updateUsernameAndPassword(username, userRequestDto);
        if (userResponseDto.isPresent()){
            return ResponseEntity.ok(userResponseDto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
       userService.deleteUser(username);
       return ResponseEntity.noContent().build();
    }

}

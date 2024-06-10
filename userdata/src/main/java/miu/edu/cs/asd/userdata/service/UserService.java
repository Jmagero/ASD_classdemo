package miu.edu.cs.asd.userdata.service;

import miu.edu.cs.asd.userdata.dto.request.UserRequestDto;
import miu.edu.cs.asd.userdata.dto.response.UserResponseDto;
import miu.edu.cs.asd.userdata.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserResponseDto> findByUsername(String username);
    Optional<UserResponseDto> addUser(UserRequestDto user);
    Optional<UserResponseDto> updatePassword(String username, UserRequestDto user);
    Optional<UserResponseDto> updateUsernameAndPassword(String username, UserRequestDto user);
    void  deleteUser(String username);
    Optional<List<UserResponseDto>> getAllUsers();
}

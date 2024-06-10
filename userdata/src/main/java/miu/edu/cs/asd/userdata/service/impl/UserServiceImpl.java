package miu.edu.cs.asd.userdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.userdata.dto.request.UserRequestDto;
import miu.edu.cs.asd.userdata.dto.response.UserResponseDto;
import miu.edu.cs.asd.userdata.model.User;
import miu.edu.cs.asd.userdata.repository.UserRepository;
import miu.edu.cs.asd.userdata.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<UserResponseDto> findByUsername(String username) {
        Optional<User> foundUser = userRepository.findByUsername(username);
//        if (foundUser.isPresent()) {
//            return Optional.of(modelMapper.map(foundUser.get(), UserResponseDto.class));
//        }
//        return Optional.empty();
        return foundUser.map(user -> modelMapper.map(user, UserResponseDto.class));
    }

    @Override
    public Optional<UserResponseDto> addUser(UserRequestDto user) {
        User newUser = modelMapper.map(user, User.class);
        User savedUser = userRepository.save(newUser);
        UserResponseDto userResponseDto = modelMapper.map(savedUser, UserResponseDto.class);
        return Optional.of(userResponseDto);
    }

    @Override
    public Optional<UserResponseDto> updatePassword(String username, UserRequestDto userRequestDto) {
        Optional<User> foundUser = userRepository.findByUsername(username);
        if (foundUser.isPresent()) {
            modelMapper.map(userRequestDto, foundUser.get());
            User savedUser = userRepository.save(foundUser.get());
            UserResponseDto userResponseDto = modelMapper.map(savedUser, UserResponseDto.class);
            return Optional.of(userResponseDto);
        }
//        if(foundUser.isPresent()) {
//            User user = foundUser.get();
//            user.setPassword(userRequestDto.getPassword());
//            User savedUser = userRepository.save(user);
//            UserResponseDto userResponseDto = modelMapper.map(savedUser, UserResponseDto.class);
//            return Optional.of(userResponseDto);
//        }
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDto> updateUsernameAndPassword(String username, UserRequestDto userRequestDto) {
        Optional<User> foundUser = userRepository.findByUsername(username);
        if (foundUser.isPresent()) {
            modelMapper.map(userRequestDto, foundUser.get());
            User savedUser = userRepository.save(foundUser.get());
            UserResponseDto userResponseDto = modelMapper.map(savedUser, UserResponseDto.class);
            return Optional.of(userResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public void deleteUser(String username) {
       Optional<User> foundUser = userRepository.findByUsername(username);
       foundUser.ifPresent(userRepository::delete);
    }

    @Override
    public Optional<List<UserResponseDto>> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return Optional.empty();        }
        List<UserResponseDto> userResponseDtos = modelMapper.map(users, new TypeToken<List<UserResponseDto>>() {}.getType());
        return Optional.of(userResponseDtos);    }

}

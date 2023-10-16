package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.UserDTO;
import lk.ijse.nexttravel.entity.User;
import lk.ijse.nexttravel.repository.UserRepository;
import lk.ijse.nexttravel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public Mono<UserDTO> saveUser(UserDTO userDTO) {
        User userData = modelMapper.map(userDTO, User.class);
        return userRepository.save(userData).map(user ->
                modelMapper.map(user, UserDTO.class));
    }

    @Override
    public Mono<UserDTO> getUser(String userName) {
        Mono<User> byUserName = userRepository.findByUserName(userName);
        return byUserName.map(getUser -> modelMapper.map(getUser, UserDTO.class));
    }

    @Override
    public Flux<UserDTO> getAllUsers() {
        Flux<User> users = userRepository.findAll();
        return users.map(allUsers -> modelMapper.map(allUsers, UserDTO.class));
    }

    @Override
    public Mono<UserDTO> updateUsers(UserDTO userDTO, String userId) {
        Mono<User> updateUser = userRepository.findByUserId(userId);
        return updateUser.flatMap((existUser) ->{
            existUser.setUserName(userDTO.getUserName());
            existUser.setUserPassword(userDTO.getUserPassword());
            existUser.setUserContactNo(userDTO.getUserContactNo());
            existUser.setUserNic(userDTO.getUserNic());
            existUser.setUserAge(userDTO.getUserAge());
            existUser.setGender(userDTO.getGender());
            existUser.setAddress(userDTO.getAddress());
            existUser.setRemarks(userDTO.getRemarks());
            return userRepository.save(existUser);
        }).map(user->modelMapper.map(user,UserDTO.class));
    }

    @Override
    public Mono<Void> deleteUser(String userId) {
        return userRepository.deleteByUserId(userId);
    }
}

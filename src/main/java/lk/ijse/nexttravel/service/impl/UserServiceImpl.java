package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.UserDTO;
import lk.ijse.nexttravel.entity.User;
import lk.ijse.nexttravel.repository.UserRepository;
import lk.ijse.nexttravel.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
//@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    //save User details in db
    @Override
    public Mono<UserDTO> saveUser(UserDTO userDTO) {
        User userData = modelMapper.map(userDTO, User.class);
        return userRepository.save(userData).map(user ->
                modelMapper.map(user, UserDTO.class));
    }

    //get User details from db
    @Override
    public Mono<UserDTO> getUser(String userName) {
        Mono<User> byUserName = userRepository.findByUserName(userName);
        return byUserName.map(getUser -> modelMapper.map(getUser, UserDTO.class));
    }

    //get all User details from db
    @Override
    public Flux<UserDTO> getAllUsers() {
        Flux<User> users = userRepository.findAll();
        return users.map(allUsers -> modelMapper.map(allUsers, UserDTO.class));
    }

    //Update User details in db
    @Override
    public Mono<UserDTO> updateUsers(UserDTO userDTO, String userId) {
        Mono<User> updateUser = userRepository.findByUserId(userId);
        return updateUser.flatMap((existUser) -> {
            existUser.setUserName(userDTO.getUserName());
            existUser.setUserPassword(userDTO.getUserPassword());
            existUser.setUserContactNo(userDTO.getUserContactNo());
            existUser.setUserNic(userDTO.getUserNic());
            existUser.setUserAge(userDTO.getUserAge());
            existUser.setGender(userDTO.getGender());
            existUser.setAddress(userDTO.getAddress());
            existUser.setRemarks(userDTO.getRemarks());
            return userRepository.save(existUser);
        }).map(user -> modelMapper.map(user, UserDTO.class));
    }

    //Delete User details in db
    @Override
    public Mono<Void> deleteUser(String userId) {
        return userRepository.deleteByUserId(userId);
    }
}

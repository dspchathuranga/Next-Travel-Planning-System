package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.UserDTO;
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
        return null;
    }

    @Override
    public Mono<UserDTO> getUser(String userName) {
        return null;
    }

    @Override
    public Flux<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public Mono<UserDTO> updateUsers(UserDTO userDTO, String userId) {
        return null;
    }

    @Override
    public Mono<Void> deleteUser(String userId) {
        return null;
    }
}

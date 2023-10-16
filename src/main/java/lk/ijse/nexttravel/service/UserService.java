package lk.ijse.nexttravel.service;

import lk.ijse.nexttravel.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDTO> saveUser(UserDTO userDTO);
    Mono<UserDTO>getUser(String userName);
    Flux<UserDTO> getAllUsers();
    Mono<UserDTO>updateUsers(UserDTO userDTO,String userId);
    Mono<Void>deleteUser(String userId);
}

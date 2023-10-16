package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.dto.UserDTO;
import lk.ijse.nexttravel.service.UserService;
import lk.ijse.nexttravel.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public Mono<ResponseUtil> saveUser(@RequestBody UserDTO userDTO) {
        return null;
    }

    @GetMapping("{userName}")
    public Mono<ResponseUtil> getUser(@PathVariable String userName) {
        return null;
    }

    @GetMapping("/getAll")
    public Flux<ResponseUtil> getAllUsers() {
        return null;
    }

    @PutMapping("{userId}")
    public Mono<ResponseUtil> updateUsers( @RequestBody UserDTO userDTO, @PathVariable String userId) {
        return null;
    }

    @DeleteMapping("{userId}")
    public Mono<ResponseUtil> deleteUser(@PathVariable String userId) {
        return null;
    }
}

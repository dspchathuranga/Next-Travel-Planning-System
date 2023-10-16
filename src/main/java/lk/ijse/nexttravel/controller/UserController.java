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

    //handle user Post request
    @PostMapping("/save")
    public Mono<ResponseUtil> saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO).map(savedUser ->
                new ResponseUtil(200,"User Saved",null));
    }

    //handle user get request
    @GetMapping("{userName}")
    public Mono<ResponseUtil> getUser(@PathVariable String userName) {
        return userService.getUser(userName).map(getUserData ->
                new ResponseUtil(200,"User Fetch",getUserData));
    }

    //handle get All users request
    @GetMapping("/getAll")
    public Flux<ResponseUtil> getAllUsers() {
        return userService.getAllUsers().map(allUsers ->
                new ResponseUtil(200,"get All users",allUsers));
    }

    //handle update user request
    @PutMapping("{userId}")
    public Mono<ResponseUtil> updateUsers( @RequestBody UserDTO userDTO, @PathVariable String userId) {
        return userService.updateUsers(userDTO,userId).map(updateUser ->
                new ResponseUtil(200,"Update User",null));
    }

    //handle delete user request
    @DeleteMapping("{userId}")
    public Mono<ResponseUtil> deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId).map(deleteUser ->
                new ResponseUtil(200,userId+" User Deleted",null));
    }
}

package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.dto.HotelDTO;
import lk.ijse.nexttravel.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/hotel")
public class HotelDetailsController {

    @PostMapping("/save")
    public Mono<ResponseUtil> saveHotelDetails(@RequestBody HotelDTO hotelDTO) {
        return null;
    }

    @GetMapping("{hotelName}")
    public Mono<ResponseUtil> getHotelDetails(@PathVariable String hotelName) {
        return null;
    }

    @GetMapping("/getAll")
    public Flux<ResponseUtil> getAllHotelDetails() {
        return null;
    }

    @PutMapping("{hotelId}")
    public Mono<ResponseUtil> updateHotelDetails(@RequestBody HotelDTO hotelDTO,@PathVariable int hotelId) {
        return null;
    }

    @DeleteMapping("{hotelId}")
    public Mono<ResponseUtil> deleteHotel(@PathVariable int hotelId) {
        return null;
    }
}

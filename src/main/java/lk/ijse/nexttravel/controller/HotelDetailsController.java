package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.dto.HotelDTO;
import lk.ijse.nexttravel.service.HotelService;
import lk.ijse.nexttravel.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel")
@CrossOrigin(origins = {"*"})
public class HotelDetailsController {

    private final HotelService hotelService;

    @PostMapping("/save")
    public Mono<ResponseUtil> saveHotelDetails(@RequestBody HotelDTO hotelDTO) {
        return hotelService.saveHotelDetails(hotelDTO).map(savedHotel ->
                new ResponseUtil(200, "Hotel saved Success...", savedHotel));
    }

    @GetMapping("{hotelName}")
    public Mono<ResponseUtil> getHotelDetails(@PathVariable String hotelName) {
        return null;
    }

    @GetMapping("/getAll")
    public Flux<ResponseUtil> getAllHotelDetails() {
        return hotelService.getAllHotelDetails().map(allHotels ->
                new ResponseUtil(200, "All Hotels Fetched...", allHotels));
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

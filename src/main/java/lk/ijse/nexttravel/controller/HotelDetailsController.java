package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.dto.HotelCategoryDTO;
import lk.ijse.nexttravel.dto.HotelDTO;
import lk.ijse.nexttravel.dto.MealPlaneDTO;
import lk.ijse.nexttravel.dto.RoomTypeDTO;
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

    @PostMapping("/category/save")
    public Mono<ResponseUtil> saveHotelCategory(@RequestBody HotelCategoryDTO hotelCategoryDTO) {
        return hotelService.saveHotelCategory(hotelCategoryDTO).map(savedHotelCategory ->
                new ResponseUtil(200, "Hotel Category saved Success...", savedHotelCategory));
    }

    @PostMapping("/meal-plane/save")
    public Mono<ResponseUtil> saveMealPlane(@RequestBody MealPlaneDTO mealPlaneDTO) {
        return hotelService.saveMealPlane(mealPlaneDTO).map(savedMealPlane ->
                new ResponseUtil(200, "Meal Plane saved Success...", savedMealPlane));
    }

    @PostMapping("/room-type/save")
    public Mono<ResponseUtil> saveRoomType(@RequestBody RoomTypeDTO roomTypeDTO) {
        return hotelService.saveRoomType(roomTypeDTO).map(savedRoomType ->
                new ResponseUtil(200, "Room Type saved Success...", savedRoomType));
    }

    @GetMapping("{hotelId}")
    public Mono<ResponseUtil> getHotelDetailById(@PathVariable String hotelId) {
        return hotelService.getHotelDetailById(hotelId).map(hotel ->
                new ResponseUtil(200, "Hotel found Success...", hotel));
    }

    @GetMapping("/category/{hotelCategoryId}")
    public Mono<ResponseUtil> getHotelCategoryById(@PathVariable String hotelCategoryId) {
        return hotelService.getHotelCategoryById(hotelCategoryId).map(hotelCategory ->
                new ResponseUtil(200, "Hotel Category found Success...", hotelCategory));
    }

    @GetMapping("/getAll")
    public Flux<ResponseUtil> getAllHotelDetails() {
        return hotelService.getAllHotelDetails().map(allHotels ->
                new ResponseUtil(200, "All Hotels Fetched...", allHotels));
    }

    @GetMapping("/category/getAll")
    public Flux<ResponseUtil> getAllHotelCategory() {
        return hotelService.getAllHotelCategory().map(allHotelCategory ->
                new ResponseUtil(200, "All Hotels Category Fetched...", allHotelCategory));
    }

    @PutMapping("{hotelId}")
    public Mono<ResponseUtil> updateHotelDetails(@RequestBody HotelDTO hotelDTO, @PathVariable String hotelId) {
        return hotelService.updateHotelDetails(hotelDTO, hotelId).map(hotel ->
                new ResponseUtil(200, "Hotel found Success...", hotel));
    }

    @PutMapping("/category/{hotelCategoryId}")
    public Mono<ResponseUtil> updateHotelCategory(@RequestBody HotelCategoryDTO hotelCategoryDTO,@PathVariable String hotelCategoryId) {
        return hotelService.updateHotelCategory(hotelCategoryDTO, hotelCategoryId).map(hotelCategory ->
                new ResponseUtil(200, "Hotel Category found Success...", hotelCategory));
    }

    @DeleteMapping("{hotelId}")
    public Mono<Void> deleteHotel(@PathVariable String hotelId) {
        return hotelService.deleteHotel(hotelId);
    }

    @DeleteMapping("/category/{hotelCategoryId}")
    public Mono<Void> deleteHotelCategory(@PathVariable String hotelCategoryId) {
        return hotelService.deleteHotelCategory(hotelCategoryId);
    }
}

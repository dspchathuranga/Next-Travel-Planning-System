package lk.ijse.nexttravel.service;

import io.micrometer.observation.ObservationFilter;
import lk.ijse.nexttravel.dto.*;
import lk.ijse.nexttravel.util.ResponseUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HotelService {
    Mono<HotelDTO>saveHotelDetails(HotelDTO hotelDTO);
    Flux<HotelDTO>getAllHotelDetails();
    Mono<HotelDTO>updateHotelDetails(HotelDTO hotelDTO, String hotelId);
    Mono<Void>deleteHotel(String hotelId);

    Mono<HotelCategoryDTO> saveHotelCategory(HotelCategoryDTO hotelCategoryDTO);

    Flux<HotelCategoryDTO> getAllHotelCategory();

    Mono<HotelDTO> getHotelDetailById(String hotelId);

    Mono<HotelCategoryDTO> getHotelCategoryById(String hotelCategoryId);

    Mono<HotelCategoryDTO> updateHotelCategory(HotelCategoryDTO hotelCategoryDTO, String hotelCategoryId);

    Mono<Void> deleteHotelCategory(String hotelCategoryId);

    Mono<MealPlaneDTO> saveMealPlane(MealPlaneDTO mealPlaneDTO);

    Mono<RoomTypeDTO> saveRoomType(RoomTypeDTO roomTypeDTO);
}

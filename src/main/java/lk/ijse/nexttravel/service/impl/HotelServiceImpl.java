package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.*;
import lk.ijse.nexttravel.entity.*;
import lk.ijse.nexttravel.repository.HotelCategoryRepository;
import lk.ijse.nexttravel.repository.HotelRepository;
import lk.ijse.nexttravel.repository.MealPlaneRepository;
import lk.ijse.nexttravel.repository.RoomTypeRepository;
import lk.ijse.nexttravel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelServiceImpl implements HotelService {

    private final ModelMapper modelMapper;

    private final HotelRepository hotelRepository;

    private final HotelCategoryRepository hotelCategoryRepository;

    private final MealPlaneRepository mealPlaneRepository;

    private final RoomTypeRepository roomTypeRepository;

    @Override
    public Mono<HotelDTO> saveHotelDetails(HotelDTO hotelDTO) {
        Hotel saveHotel = modelMapper.map(hotelDTO, Hotel.class);
        hotelDTO.getRoomDTOList().stream().forEach(roomDTO -> System.out.println(roomDTO.toString()));
        saveHotel.setRoomDetailsList(
                hotelDTO.getRoomDTOList().stream().map(roomDTO -> modelMapper.map(roomDTO, RoomDetails.class)).toList()
        );
        saveHotel.getRoomDetailsList().stream().forEach(roomDetails -> System.out.println(roomDetails.toString()));
        System.out.println(saveHotel.getRoomDetailsList());
        return hotelRepository.save(saveHotel)
                .map(savedHotel -> {
                    HotelDTO savedHotelDTO = modelMapper.map(savedHotel, HotelDTO.class);
                    savedHotelDTO.setHotelCategoryDTO(modelMapper.map(savedHotel.getHotelCategory(), HotelCategoryDTO.class));
                    savedHotelDTO.setRoomDTOList(savedHotel.getRoomDetailsList().stream().map(roomDetails -> {
                        RoomDTO roomDTO = modelMapper.map(roomDetails, RoomDTO.class);
                        roomDTO.setHotelRoomTypeDTOList(roomDetails.getHotelRoomTypeList().stream().map(
                                hotelRoomType -> modelMapper.map(hotelRoomType, HotelRoomTypeDTO.class)
                        ).toList());
                        roomDTO.setHotelMealPlaneDTOList(roomDetails.getHotelMealPlaneList().stream().map(
                                hotelMealPlane -> modelMapper.map(hotelMealPlane, HotelMealPlaneDTO.class)
                        ).toList());
                        return roomDTO;
                    }).toList());
                    return savedHotelDTO;
                });
    }

    @Override
    public Flux<HotelDTO> getAllHotelDetails() {
        return hotelRepository.findAll().map(hotel -> {
            HotelDTO hotelDTO = modelMapper.map(hotel, HotelDTO.class);
            hotelDTO.setHotelCategoryDTO(modelMapper.map(hotel.getHotelCategory(), HotelCategoryDTO.class));
            hotelDTO.setRoomDTOList(hotel.getRoomDetailsList().stream().map(roomDetails -> {
                RoomDTO roomDTO = modelMapper.map(roomDetails, RoomDTO.class);
                roomDTO.setHotelRoomTypeDTOList(roomDetails.getHotelRoomTypeList().stream().map(
                        hotelRoomType -> modelMapper.map(hotelRoomType, HotelRoomTypeDTO.class)
                ).toList());
                roomDTO.setHotelMealPlaneDTOList(roomDetails.getHotelMealPlaneList().stream().map(
                        hotelMealPlane -> modelMapper.map(hotelMealPlane, HotelMealPlaneDTO.class)
                ).toList());
                return roomDTO;
            }).toList());
            return hotelDTO;
        });
    }

    @Override
    public Mono<HotelDTO> updateHotelDetails(HotelDTO hotelDTO, String hotelId) {
        Hotel saveHotel = modelMapper.map(hotelDTO, Hotel.class);
        Mono<Hotel> updateHotel = hotelRepository.findById(saveHotel.getHotelId());

        if(updateHotel != null){
            return hotelRepository.save(saveHotel).map(hotel -> modelMapper.map(hotel,  HotelDTO.class));
        }
        return  updateHotel.map(hotel -> modelMapper.map(hotel,  HotelDTO.class));
    }

    @Override
    public Mono<Void> deleteHotel(String hotelId) {
        return hotelRepository.deleteByHotelId(hotelId);
    }

    @Override
    public Mono<HotelCategoryDTO> saveHotelCategory(HotelCategoryDTO hotelCategoryDTO) {
        HotelCategory saveHotelCategory = modelMapper.map(hotelCategoryDTO, HotelCategory.class);
        return hotelCategoryRepository.save(saveHotelCategory)
                .map(savedHotelCategory -> modelMapper.map(savedHotelCategory, HotelCategoryDTO.class));
    }

    @Override
    public Flux<HotelCategoryDTO> getAllHotelCategory() {
        return hotelCategoryRepository.findAll().map(hotelCategory -> modelMapper.map(hotelCategory, HotelCategoryDTO.class));
    }

    @Override
    public Mono<HotelDTO> getHotelDetailById(String hotelId) {
        return hotelRepository.findById(hotelId).map(hotel -> modelMapper.map(hotel, HotelDTO.class));
    }

    @Override
    public Mono<HotelCategoryDTO> getHotelCategoryById(String hotelCategoryId) {
        return hotelCategoryRepository.findById(hotelCategoryId).map(hotelCategory -> modelMapper.map(hotelCategory, HotelCategoryDTO.class));
    }

    @Override
    public Mono<HotelCategoryDTO> updateHotelCategory(HotelCategoryDTO hotelCategoryDTO, String hotelCategoryId) {
        HotelCategory saveHotelCategory = modelMapper.map(hotelCategoryDTO, HotelCategory.class);
        Mono<HotelCategory> updateHotelCategory = hotelCategoryRepository.findById(saveHotelCategory.getHotelCategoryId());

        if(updateHotelCategory != null){
            return hotelCategoryRepository.save(saveHotelCategory).map(hotelCategory -> modelMapper.map(hotelCategory,  HotelCategoryDTO.class));
        }
        return  updateHotelCategory.map(hotelCategory -> modelMapper.map(hotelCategory,  HotelCategoryDTO.class));
    }

    @Override
    public Mono<Void> deleteHotelCategory(String hotelCategoryId) {
        return hotelCategoryRepository.deleteById(hotelCategoryId);
    }

    @Override
    public Mono<MealPlaneDTO> saveMealPlane(MealPlaneDTO mealPlaneDTO) {
        MealPlane saveMealPlane = modelMapper.map(mealPlaneDTO, MealPlane.class);
        return mealPlaneRepository.save(saveMealPlane).map(mealPlane -> modelMapper.map(mealPlane, MealPlaneDTO.class));
    }

    @Override
    public Mono<RoomTypeDTO> saveRoomType(RoomTypeDTO roomTypeDTO) {
        RoomType saveRoomType = modelMapper.map(roomTypeDTO, RoomType.class);
        return roomTypeRepository.save(saveRoomType).map(roomType -> modelMapper.map(roomType, RoomTypeDTO.class));
    }
}

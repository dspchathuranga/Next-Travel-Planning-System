package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.GuideDTO;
import lk.ijse.nexttravel.dto.HotelDTO;
import lk.ijse.nexttravel.entity.Guide;
import lk.ijse.nexttravel.entity.Hotel;
import lk.ijse.nexttravel.repository.HotelRepository;
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

    @Override
    public Mono<HotelDTO> saveHotelDetails(HotelDTO hotelDTO) {
        Hotel saveHotel = modelMapper.map(hotelDTO, Hotel.class);
        return hotelRepository.save(saveHotel)
                .map(savedHotel -> modelMapper.map(savedHotel, HotelDTO.class));
    }

    @Override
    public Mono<HotelDTO> getHotelDetails(String hotelName) {
        return null;
    }

    @Override
    public Flux<HotelDTO> getAllHotelDetails() {
        return null;
    }

    @Override
    public Mono<HotelDTO> updateHotelDetails(HotelDTO hotelDTO, int hotelId) {
        return null;
    }

    @Override
    public Mono<Void> deleteHotel(int hotelId) {
        return null;
    }
}

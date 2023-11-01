package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.Guide;
import lk.ijse.nexttravel.entity.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface HotelRepository extends ReactiveMongoRepository<Hotel,String> {
    Mono<Guide>findByHotelName(String hotelName);
    Mono<Guide>findByHotelId(String hotelId);
    Mono<Void>deleteByHotelId(String hotelId);
}

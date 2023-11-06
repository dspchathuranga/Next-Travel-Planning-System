package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.RoomType;
import lk.ijse.nexttravel.entity.TravelArea;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TravelAreaRepository extends ReactiveMongoRepository<TravelArea,String> {
}

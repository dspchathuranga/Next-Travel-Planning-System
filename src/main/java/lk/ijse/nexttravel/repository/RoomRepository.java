package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.Hotel;
import lk.ijse.nexttravel.entity.RoomDetails;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoomRepository extends ReactiveMongoRepository<RoomDetails,Integer> {
}

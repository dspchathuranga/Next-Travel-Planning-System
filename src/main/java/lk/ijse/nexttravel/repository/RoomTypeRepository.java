package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.RoomDetails;
import lk.ijse.nexttravel.entity.RoomType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoomTypeRepository extends ReactiveMongoRepository<RoomType,String> {
}

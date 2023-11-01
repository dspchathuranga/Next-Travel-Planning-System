package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.MealPlane;
import lk.ijse.nexttravel.entity.RoomDetails;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MealPlaneRepository extends ReactiveMongoRepository<MealPlane,String> {
}

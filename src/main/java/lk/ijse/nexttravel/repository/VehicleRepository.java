package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends ReactiveMongoRepository<Vehicle,Integer> {
}

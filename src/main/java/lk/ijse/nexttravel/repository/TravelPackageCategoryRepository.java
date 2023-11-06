package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.RoomType;
import lk.ijse.nexttravel.entity.TravelPackageCategory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TravelPackageCategoryRepository extends ReactiveMongoRepository<TravelPackageCategory,String> {
}

package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.TravelPackageCategory;
import lk.ijse.nexttravel.entity.TravelPackagePromotion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TravelPackagePromotionRepository extends ReactiveMongoRepository<TravelPackagePromotion,String> {
}

package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.dto.HelloDto;
import lk.ijse.nexttravel.entity.HotelCategory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HotelCategoryRepository extends ReactiveMongoRepository<HotelCategory,String> {
}

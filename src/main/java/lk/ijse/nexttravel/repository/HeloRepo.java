package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.dto.HelloDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface HeloRepo extends ReactiveMongoRepository<HelloDto,String> {
    Mono<HelloDto>findByName(String name);
}

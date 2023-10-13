package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.Guide;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface GuideRepository extends ReactiveMongoRepository<Guide,String> {
    Mono<Guide>findByGuidId(String guidId);
    Mono<Void>deleteByGuidId(String guidId);
}

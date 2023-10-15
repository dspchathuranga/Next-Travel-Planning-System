package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.model.Image;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ImageRepository extends ReactiveMongoRepository<Image, String> {
    Mono<Image> findByImageUrl(String imageUrl);
}

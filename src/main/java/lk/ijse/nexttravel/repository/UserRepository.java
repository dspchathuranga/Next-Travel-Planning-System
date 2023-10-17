package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User,String> {
    Mono<User>findByUserId(String userId);
    Mono<User>findByUserName(String userName);
    Mono<Void>deleteByUserId(String userId);
}

package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Mono<User>findByUserName(String userName);
    Mono<User>findByUserId(String userId);
}

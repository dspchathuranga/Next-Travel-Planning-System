package lk.ijse.nexttravel.repository;

import lk.ijse.nexttravel.entity.CancellationPolicy;
import lk.ijse.nexttravel.entity.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CancellationPolicyRepository extends ReactiveMongoRepository<CancellationPolicy,String> {
}

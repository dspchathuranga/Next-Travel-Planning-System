package lk.ijse.nexttravel.service;

import lk.ijse.nexttravel.dto.GuideDTO;
import lk.ijse.nexttravel.dto.TravelPackageDTO;
import lk.ijse.nexttravel.entity.TravelPackage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TravelPackageService {
    Mono<TravelPackageDTO> savePackage(TravelPackageDTO packageDTO);
    Mono<TravelPackageDTO>getPackage(String packageName);
    Flux<TravelPackageDTO> getAllPackages();
    Mono<TravelPackageDTO>updatePackage(TravelPackageDTO packageDTO,String packageId);
    Mono<Void>deletePackage(String packageId);
}

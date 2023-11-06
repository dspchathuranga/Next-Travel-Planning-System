package lk.ijse.nexttravel.service;

import io.micrometer.observation.ObservationFilter;
import lk.ijse.nexttravel.dto.*;
import lk.ijse.nexttravel.entity.TravelPackage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TravelPackageService {
    Mono<TravelPackageDTO> savePackage(TravelPackageDTO packageDTO);
    Mono<TravelPackageDTO>getPackage(String packageName);
    Flux<TravelPackageDTO> getAllPackages();
    Mono<TravelPackageDTO>updatePackage(TravelPackageDTO packageDTO,String packageId);
    Mono<Void>deletePackage(String packageId);

    Mono<TravelPackageCategoryDTO> saveTravelPackageCategory(TravelPackageCategoryDTO travelPackageCategoryDTO);

    Mono<TravelAreaDTO> saveTravelArea(TravelAreaDTO travelAreaDTO);

    Mono<TravelPackagePromotionDTO> saveTravelPackagePromotion(TravelPackagePromotionDTO travelPackagePromotionDTO);

    Flux<TravelPackageCategoryDTO> getTravelPackageCategory();

    Flux<TravelAreaDTO> getTravelArea();

    Flux<TravelPackagePromotionDTO> getTravelPackagePromotion();
}

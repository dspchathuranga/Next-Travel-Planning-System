package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.TravelAreaDTO;
import lk.ijse.nexttravel.dto.TravelPackageCategoryDTO;
import lk.ijse.nexttravel.dto.TravelPackageDTO;
import lk.ijse.nexttravel.dto.TravelPackagePromotionDTO;
import lk.ijse.nexttravel.entity.TravelArea;
import lk.ijse.nexttravel.entity.TravelPackage;
import lk.ijse.nexttravel.entity.TravelPackageCategory;
import lk.ijse.nexttravel.entity.TravelPackagePromotion;
import lk.ijse.nexttravel.repository.TravelAreaRepository;
import lk.ijse.nexttravel.repository.TravelPackageCategoryRepository;
import lk.ijse.nexttravel.repository.TravelPackagePromotionRepository;
import lk.ijse.nexttravel.repository.TravelPackageRepository;
import lk.ijse.nexttravel.service.TravelPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class PackageServiceImpl implements TravelPackageService {

    private final TravelPackageRepository packageRepository;

    private final ModelMapper modelMapper;

    private final TravelAreaRepository travelAreaRepository;

    private final TravelPackageCategoryRepository travelPackageCategoryRepository;

    private final TravelPackagePromotionRepository travelPackagePromotionRepository;

    //save travel packages in database
    @Override
    public Mono<TravelPackageDTO> savePackage(TravelPackageDTO packageDTO) {
        TravelPackage travelPackage = modelMapper.map(packageDTO, TravelPackage.class);
        return packageRepository.save(travelPackage)
                .map(savedPackage->modelMapper.map(savedPackage,TravelPackageDTO.class));
    }

    //get travel package from database
    @Override
    public Mono<TravelPackageDTO> getPackage(String packageName) {
        Mono<TravelPackage> byPackageName = packageRepository.findByPackageName(packageName);
        return byPackageName.map(getPackage ->modelMapper.map(getPackage,TravelPackageDTO.class));
    }

    //get All travel packages from database
    @Override
    public Flux<TravelPackageDTO> getAllPackages() {
        Flux<TravelPackage> allPackages = packageRepository.findAll();
        return allPackages.map(travelPackages ->modelMapper.map(travelPackages,TravelPackageDTO.class))
                .switchIfEmpty(Flux.empty());
    }

    //update travel packages in database
    @Override
    public Mono<TravelPackageDTO> updatePackage(TravelPackageDTO packageDTO, String packageId) {
        return null;
    }

    //delete travel package from database
    @Override
    public Mono<Void> deletePackage(String packageId) {
        return packageRepository.deleteById(packageId);
    }

    @Override
    public Mono<TravelPackageCategoryDTO> saveTravelPackageCategory(TravelPackageCategoryDTO travelPackageCategoryDTO) {
        TravelPackageCategory travelPackageCategory = modelMapper.map(travelPackageCategoryDTO, TravelPackageCategory.class);
        return travelPackageCategoryRepository.save(travelPackageCategory)
                .map(savedTravelPackageCategory -> modelMapper.map(savedTravelPackageCategory,TravelPackageCategoryDTO.class));
    }

    @Override
    public Mono<TravelAreaDTO> saveTravelArea(TravelAreaDTO travelAreaDTO) {
        TravelArea travelArea = modelMapper.map(travelAreaDTO, TravelArea.class);
        return travelAreaRepository.save(travelArea)
                .map(savedTravelArea -> modelMapper.map(savedTravelArea,TravelAreaDTO.class));
    }

    @Override
    public Mono<TravelPackagePromotionDTO> saveTravelPackagePromotion(TravelPackagePromotionDTO travelPackagePromotionDTO) {
        TravelPackagePromotion travelPackagePromotion = modelMapper.map(travelPackagePromotionDTO, TravelPackagePromotion.class);
        return travelPackagePromotionRepository.save(travelPackagePromotion)
                .map(savedTravelPackagePromotion -> modelMapper.map(savedTravelPackagePromotion,TravelPackagePromotionDTO.class));
    }

    @Override
    public Flux<TravelPackageCategoryDTO> getTravelPackageCategory() {
        Flux<TravelPackageCategory> allPackageCategory = travelPackageCategoryRepository.findAll();
        return allPackageCategory.map(travelPackageCategory ->modelMapper.map(travelPackageCategory,TravelPackageCategoryDTO.class))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Flux<TravelAreaDTO> getTravelArea() {
        Flux<TravelArea> allTravelArea = travelAreaRepository.findAll();
        return allTravelArea.map(travelArea ->modelMapper.map(travelArea,TravelAreaDTO.class))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Flux<TravelPackagePromotionDTO> getTravelPackagePromotion() {
        Flux<TravelPackagePromotion> allTravelPackagePromotion = travelPackagePromotionRepository.findAll();
        return allTravelPackagePromotion.map(travelPackagePromotion ->modelMapper.map(travelPackagePromotion,TravelPackagePromotionDTO.class))
                .switchIfEmpty(Flux.empty());
    }
}

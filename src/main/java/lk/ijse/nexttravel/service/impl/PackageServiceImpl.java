package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.TravelPackageDTO;
import lk.ijse.nexttravel.entity.TravelPackage;
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

    @Override
    public Mono<TravelPackageDTO> savePackage(TravelPackageDTO packageDTO) {
        TravelPackage travelPackage = modelMapper.map(packageDTO, TravelPackage.class);
        return packageRepository.save(travelPackage)
                .map(savedPackage->modelMapper.map(savedPackage,TravelPackageDTO.class));
    }

    @Override
    public Mono<TravelPackageDTO> getPackage(String packageName) {
        Mono<TravelPackage> byPackageName = packageRepository.findByPackageName(packageName);
        return byPackageName.map(getPackage ->modelMapper.map(getPackage,TravelPackageDTO.class));
    }

    @Override
    public Flux<TravelPackageDTO> getAllPackages() {
        Flux<TravelPackage> allPackages = packageRepository.findAll();
        return allPackages.map(travelPackages ->modelMapper.map(travelPackages,TravelPackageDTO.class))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<TravelPackageDTO> updatePackage(TravelPackageDTO packageDTO, int packageId) {
        return null;
    }

    @Override
    public Mono<Void> deletePackage(int packageId) {
        return packageRepository.deleteByPackageId(packageId);
    }
}

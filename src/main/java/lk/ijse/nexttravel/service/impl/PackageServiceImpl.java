package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.TravelPackageDTO;
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
        return null;
    }

    @Override
    public Mono<TravelPackageDTO> getPackage(String packageName) {
        return null;
    }

    @Override
    public Flux<TravelPackageDTO> getAllPackages() {
        return null;
    }

    @Override
    public Mono<TravelPackageDTO> updatePackage(TravelPackageDTO packageDTO, int packageId) {
        return null;
    }

    @Override
    public Mono<Void> deletePackage(int packageId) {
        return null;
    }
}

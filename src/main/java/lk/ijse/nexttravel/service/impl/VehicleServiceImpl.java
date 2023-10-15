package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.VehicleDTO;
import lk.ijse.nexttravel.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Override
    public Mono<VehicleDTO> saveVehicle(VehicleDTO vehicleDTO) {
        return null;
    }

    @Override
    public Mono<VehicleDTO> getVehicle(int vehicleId) {
        return null;
    }

    @Override
    public Flux<VehicleDTO> getAllVehicles() {
        return null;
    }

    @Override
    public Mono<VehicleDTO> updateVehicle(VehicleDTO vehicleDTO, int vehicleId) {
        return null;
    }

    @Override
    public Mono<Void> deleteVehicle(int vehicleId) {
        return null;
    }
}

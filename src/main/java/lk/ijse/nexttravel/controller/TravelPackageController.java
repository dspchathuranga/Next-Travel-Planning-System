package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.dto.TravelPackageDTO;
import lk.ijse.nexttravel.service.TravelPackageService;
import lk.ijse.nexttravel.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/package")
public class TravelPackageController {

    private final TravelPackageService packageService;

    @PostMapping("/save")
    public Mono<ResponseUtil> savePackageDetails(@RequestBody TravelPackageDTO packageDTO) {
        return null;
    }

    @GetMapping("{packageName}")
    public Mono<ResponseUtil> getPackageDetails(@PathVariable String packageName) {
        return null;
    }

    @GetMapping("/getAll")
    public Flux<ResponseUtil> getAllPackageDetails() {
        return null;
    }

    @PutMapping("{packageId}")
    public Mono<ResponseUtil> updatePackageDetails(@RequestBody TravelPackageDTO packageDTO,@PathVariable int packageId) {
        return null;
    }

    @DeleteMapping("{packageId}")
    public Mono<ResponseUtil> deletePackage(@PathVariable int packageId) {
        return null;
    }
}

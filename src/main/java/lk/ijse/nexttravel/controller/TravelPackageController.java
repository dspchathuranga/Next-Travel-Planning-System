package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.dto.TravelAreaDTO;
import lk.ijse.nexttravel.dto.TravelPackageCategoryDTO;
import lk.ijse.nexttravel.dto.TravelPackageDTO;
import lk.ijse.nexttravel.dto.TravelPackagePromotionDTO;
import lk.ijse.nexttravel.service.TravelPackageService;
import lk.ijse.nexttravel.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/package")
@CrossOrigin(origins = {"*"})
public class TravelPackageController {

    private final TravelPackageService packageService;

    @PostMapping("/save")
    public Mono<ResponseUtil> savePackageDetails(@RequestBody TravelPackageDTO packageDTO) {
        return packageService.savePackage(packageDTO).map(savedPackage ->
                new ResponseUtil(200, "package saved", null));
    }

    @PostMapping("/travel-package-category/save")
    public Mono<ResponseUtil> saveTravelPackageCategory(@RequestBody TravelPackageCategoryDTO travelPackageCategoryDTO) {
        return packageService.saveTravelPackageCategory(travelPackageCategoryDTO).map(savedTravelPackageCategory ->
                new ResponseUtil(200, "Travel Package Category Saved", savedTravelPackageCategory));
    }

    @PostMapping("/travel-area/save")
    public Mono<ResponseUtil> saveTravelArea(@RequestBody TravelAreaDTO travelAreaDTO) {
        return packageService.saveTravelArea(travelAreaDTO).map(savedTravelArea ->
                new ResponseUtil(200, "Travel Area Saved", savedTravelArea));
    }

    @PostMapping("/travel-package-promotion/save")
    public Mono<ResponseUtil> saveTravelPackagePromotion(@RequestBody TravelPackagePromotionDTO travelPackagePromotionDTO) {
        return packageService.saveTravelPackagePromotion(travelPackagePromotionDTO).map(savedTravelPackagePromotion ->
                new ResponseUtil(200, "Travel Package Promotion Saved", savedTravelPackagePromotion));
    }

    @GetMapping("{packageName}")
    public Mono<ResponseUtil> getPackageDetails(@PathVariable String packageName) {
        return packageService.getPackage(packageName).map(searchPackage ->
                new ResponseUtil(200, "search package data", searchPackage));
    }

    @GetMapping("/getAll")
    public Flux<ResponseUtil> getAllPackageDetails() {
        return packageService.getAllPackages().map(allPackages ->
                new ResponseUtil(200, "fetch all packages", allPackages));
    }

    @GetMapping("/travel-package-category/getAll")
    public Flux<ResponseUtil> getTravelPackageCategory() {
        return packageService.getTravelPackageCategory().map(allTravelPackageCategory ->
                new ResponseUtil(200, "fetch all packages", allTravelPackageCategory));
    }

    @GetMapping("/travel-area/getAll")
    public Flux<ResponseUtil> getTravelArea() {
        return packageService.getTravelArea().map(allTravelArea ->
                new ResponseUtil(200, "fetch all packages", allTravelArea));
    }

    @GetMapping("/travel-package-promotion/getAll")
    public Flux<ResponseUtil> getTravelPackagePromotion() {
        return packageService.getTravelPackagePromotion().map(allTravelPackagePromotion ->
                new ResponseUtil(200, "fetch all packages", allTravelPackagePromotion));
    }

    @PutMapping("{packageId}")
    public Mono<ResponseUtil> updatePackageDetails(@RequestBody TravelPackageDTO packageDTO, @PathVariable String packageId) {
        return packageService.updatePackage(packageDTO, packageId).map(updatedPackage ->
                new ResponseUtil(200, "Package updated", null));
    }

    @DeleteMapping("{packageId}")
    public Mono<ResponseUtil> deletePackage(@PathVariable String packageId) {
        return packageService.deletePackage(packageId).map(deletedPackage ->
                new ResponseUtil(200, "package deleted", null));
    }
}

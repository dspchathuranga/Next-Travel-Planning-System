package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.dto.GuideDTO;
import lk.ijse.nexttravel.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class GuideController {

    @Autowired
    GuideService guideService;

    //handle guid Post request
    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<GuideDTO> saveGuide(@RequestBody GuideDTO guideDTO) {
        if (guideDTO == null) {
            throw new RuntimeException("GuideDto is null");
        } else {
            Mono<GuideDTO> guideDTOMono = guideService.saveGuide(guideDTO);
            System.out.println("guid Saved");
            return guideDTOMono;
        }

    }

    //handle guid get request
    @GetMapping("{guidId}")
    public Mono<GuideDTO> getGuide(@PathVariable String guidId) {
        if (guidId == null) {
            throw new RuntimeException("GuideId is null");
        } else {
            Mono<GuideDTO> guideData = guideService.getGuide(guidId);
            return guideData;
        }
    }

    //handle get all guides request
    @GetMapping("/getAll")
    public Flux<GuideDTO> getAllGuides() {
        return guideService.getAllGuides();
    }

    //handle PUt request to update guide details
    @PutMapping("{guidId}")
    public Mono<GuideDTO> updateGuidData(@RequestBody GuideDTO guideDTO, @PathVariable String guidId) {
        Mono<GuideDTO> updatedGuide = guideService.updateGuide(guideDTO, guidId);
        return updatedGuide;
    }

    //handle Delete request to delete guide details by id
    @DeleteMapping("{guidId}")
    public Mono<Void>deleteGuidData(@PathVariable String guidId){
        return guideService.deleteGuide(guidId);
    }
}

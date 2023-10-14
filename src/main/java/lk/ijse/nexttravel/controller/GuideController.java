package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.dto.GuideDTO;
import lk.ijse.nexttravel.dto.HelloDto;
import lk.ijse.nexttravel.repository.HeloRepo;
import lk.ijse.nexttravel.service.GuideService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Base64;

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
    public Mono<Void> deleteGuidData(@PathVariable String guidId) {
        return guideService.deleteGuide(guidId);
    }

    //    @PostMapping(value = "/customer-profile-pictures",consumes = )
    public Mono<HelloDto> saveProfilePicture(@RequestBody HelloDto helloDto, @RequestParam("image") byte[] image) {
        helloDto.setProfile(image);
        System.out.println(helloDto);
        return null;
    }

    @Autowired
    HeloRepo heloRepo;


 //save guid profile_img
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, value = "/upload")
    public Mono<HelloDto> uploadData(
            @RequestPart("name") String name,
            @RequestPart("address") String address,
            @RequestPart("image") Part image, // Use Part instead of MultipartFile
            @RequestPart("id") String id
    ) {
        return DataBufferUtils.join(image.content())
                .map(dataBuffer -> {
                    byte[] content = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(content);
                    DataBufferUtils.release(dataBuffer);
                    return content;
                })
                .flatMap(contentBytes -> heloRepo.save(new HelloDto(id, name, address, contentBytes)))
                .map(data ->new HelloDto(data.getId(),data.getName(),data.getAddress(),data.getProfile()));
    }

    @GetMapping(value = "/image/{name}", produces = MediaType.IMAGE_PNG_VALUE)
    public Mono<byte[]> getImage(@PathVariable String name) {
        return heloRepo.findByName(name)
                .map(HelloDto::getProfile);
    }


}

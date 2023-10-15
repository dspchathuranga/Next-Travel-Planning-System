package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public Mono<String> uploadImage(@RequestPart("file") FilePart filePart) {
        return imageService.SaveImageLocally(filePart);
    }

    @GetMapping("/image/{imageId}")
    public Mono<String> getImageUrl(@PathVariable String imageId) {
        return imageService.getImageUrlById(imageId);
    }
}

package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/helo")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public Mono<String> uploadImage(@RequestPart("file") FilePart filePart) {
        return imageService.SaveImageLocally(filePart);
    }
}

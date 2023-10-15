package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.service.ImageService;
import lk.ijse.nexttravel.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ImageController {

    private final ImageService imageService;

    //handle file save req
    @PostMapping("/upload")
    public Mono<ResponseUtil> uploadImage(@RequestPart("file") FilePart filePart) {
        return imageService.SaveImageLocally(filePart).map(savedFile ->
                new ResponseUtil(200,"Image saved Successfully",null));
    }

    //handle file get req
    @GetMapping("/image/{imageId}")
    public Mono<ResponseUtil> getImageUrl(@PathVariable String imageId) {
        return imageService.getImageUrlById(imageId).map(getFile->
                new ResponseUtil(200,imageId+" fetch success",getFile));
    }
}

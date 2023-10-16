package lk.ijse.nexttravel.controller;

import lk.ijse.nexttravel.service.ImageService;
import lk.ijse.nexttravel.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.File;

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

    @GetMapping("/download/{imageId}")
    public ResponseEntity<FileSystemResource> downloadImage(@PathVariable String imageId) {
        // Get the file path based on the image ID or URL
        System.out.println("awaaaa");
        Mono<String> filePath = imageService.getImageUrlById(imageId);
        System.out.println(filePath);

        if (filePath != null) {
            // Create a FileSystemResource representing the file
            FileSystemResource resource = new FileSystemResource(new File(String.valueOf((filePath))));
            System.out.println("pahukaa2");
            // Define response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "downloaded_image"); // Change the filename if needed
            System.out.println("pahukaa3");
            // Return the file as a ResponseEntity
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } else {
            // Handle the case where the file is not found
            return ResponseEntity.notFound().build();
        }
    }

    //handle file get req
    @GetMapping("/image/{imageId}")
    public Mono<ResponseUtil> getImageUrl(@PathVariable String imageId) {
        return imageService.getImageUrlById(imageId).map(getFile->
                new ResponseUtil(200,imageId+" fetch success",getFile));
    }
}

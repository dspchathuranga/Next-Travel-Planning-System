package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.model.Image;
import lk.ijse.nexttravel.repository.ImageRepository;
import lk.ijse.nexttravel.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    //save file to the local storage
    @Override
    public Mono<String> SaveImageLocally(FilePart filePart) {
        String directory = "D:\\Spring-Boot-Projects\\NextTravel Images";
        String filename = filePart.filename();
        String filePath = Paths.get(directory, filename).toString();

        return filePart.transferTo(new File(filePath))
                .then(Mono.just("D:\\Spring-Boot-Projects\\NextTravel Images" + filename))
                .flatMap(url -> {
                    Image image = new Image();
                    image.setImageUrl(url);
                    //save file url in the db
                    return imageRepository.save(image).map(Image::getImageUrl);
                });
    }

    //retrieve file from database file url
    @Override
    public Mono<String> getImageUrlById(String imageId) {
        return imageRepository.findById(imageId)
                .map(Image::getImageUrl)
                .switchIfEmpty(Mono.error(new RuntimeException("Image not found")));
    }

    @Override
    public Mono<String> getFilePathById(String imageId) {
        return null;
    }

//    @Override
//    public Mono<String> getFilePathById(String imageId) {
//        return imageRepository.findById(imageId)
//                .map(Image::getImageUrl)
//                .switchIfEmpty(Mono.error(new RuntimeException("Image not found")));
//    }
}

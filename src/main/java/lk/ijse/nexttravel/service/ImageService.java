package lk.ijse.nexttravel.service;

import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

public interface ImageService {
    Mono<String> SaveImageLocally(FilePart filePart);
    Mono<String> getImageUrlById(String imageId);
    Mono<String> getFilePathById(String imageId);
}

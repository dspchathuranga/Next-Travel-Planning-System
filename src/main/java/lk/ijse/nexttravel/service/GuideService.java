package lk.ijse.nexttravel.service;

import lk.ijse.nexttravel.dto.GuideDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GuideService {
    Mono<GuideDTO>saveGuide(GuideDTO guideDTO);
    Mono<GuideDTO>getGuide(String guideId);
    Flux<GuideDTO>getAllGuides();
    Mono<GuideDTO>updateGuide(GuideDTO guideDTO,String guidId);
    Mono<Void>deleteGuide(String guidId);
}

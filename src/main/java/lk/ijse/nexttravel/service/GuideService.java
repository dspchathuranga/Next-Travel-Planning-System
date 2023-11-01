package lk.ijse.nexttravel.service;

import lk.ijse.nexttravel.dto.GuideDTO;
import lk.ijse.nexttravel.entity.Guide;
import lk.ijse.nexttravel.util.ResponseUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GuideService {
    Mono<GuideDTO>saveGuide(GuideDTO guideDTO);
    Mono<GuideDTO>getGuide(String guidName);
    Flux<GuideDTO>getAllGuides();
    Mono<GuideDTO>updateGuide(GuideDTO guideDTO);
    Mono<Void>deleteGuide(String guidId);
}

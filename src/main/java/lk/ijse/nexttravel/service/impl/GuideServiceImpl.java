package lk.ijse.nexttravel.service.impl;

import lk.ijse.nexttravel.dto.GuideDTO;
import lk.ijse.nexttravel.entity.Guide;
import lk.ijse.nexttravel.repository.GuideRepository;
import lk.ijse.nexttravel.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class GuideServiceImpl implements GuideService {

    private final ModelMapper modelMapper;

    private final GuideRepository guideRepository;

    //save guid details in db
    @Override
    public Mono<GuideDTO> saveGuide(GuideDTO guideDTO) {
        Guide saveGuid = modelMapper.map(guideDTO, Guide.class);
        return guideRepository.save(saveGuid)
                .map(savedGuid -> modelMapper.map(savedGuid, GuideDTO.class));
    }

    //get guid details by guid id
    @Override
    public Mono<GuideDTO> getGuide(String guideId) {
        Mono<Guide> guidMono = guideRepository.findByGuidId(guideId);
        return guidMono.map(guide -> modelMapper.map(guide, GuideDTO.class));
    }

    //get All guid details from db
    @Override
    public Flux<GuideDTO> getAllGuides() {
        Flux<Guide> allGuids = guideRepository.findAll();
        return allGuids.map(guides -> modelMapper.map(guides, GuideDTO.class))
                .switchIfEmpty(Flux.empty());
    }

    //update guid details by guid id
    @Override
    public Mono<GuideDTO> updateGuide(GuideDTO guideDTO, String guidId) {
        Mono<Guide> updateGuid = guideRepository.findByGuidId(guidId);
        return updateGuid.flatMap((existguide) -> {
            existguide.setGuidName(guideDTO.getGuidName());
            existguide.setAddress(guideDTO.getAddress());
            existguide.setContact(guideDTO.getContact());
            existguide.setExperience(guideDTO.getExperience());
            existguide.setGender(guideDTO.getGender());
            existguide.setDayValue(guideDTO.getDayValue());
            existguide.setRemarks(guideDTO.getRemarks());
            existguide.setPolicyId(guideDTO.getPolicyId());
            return guideRepository.save(existguide);
        }).map((guid -> modelMapper.map(guid, GuideDTO.class)));
    }

    //Delete guid details by guid id
    @Override
    public Mono<Void> deleteGuide(String guidId) {
       return guideRepository.deleteByGuidId(guidId);
    }
}

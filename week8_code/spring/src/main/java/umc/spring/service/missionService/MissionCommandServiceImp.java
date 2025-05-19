package umc.spring.service.missionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserFoodConverter;
import umc.spring.domain.Food;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserFood;
import umc.spring.repository.foodRepository.FoodRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImp implements MissionCommandService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.JoinDTO request) {

        Mission newMission = MissionConverter.toMission(request);
        newMission.setStore(storeRepository.findById(request.getStore())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)));

        return missionRepository.save(newMission);
    }

}

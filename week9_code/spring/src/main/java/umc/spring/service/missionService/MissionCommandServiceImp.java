package umc.spring.service.missionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserFoodConverter;
import umc.spring.domain.*;
import umc.spring.domain.mapping.UserFood;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.foodRepository.FoodRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.repository.userMissionRepository.UserMissionRepository;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;

import java.util.stream.Collectors;

import static umc.spring.domain.enums.MissionStatus.CHALLENGING;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImp implements MissionCommandService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.JoinDTO request) {

        Mission newMission = MissionConverter.toMission(request);
        newMission.setStore(storeRepository.findById(request.getStore_id()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)));

        return missionRepository.save(newMission);
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {

        page-=1;
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Page<Mission> StorePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }





}

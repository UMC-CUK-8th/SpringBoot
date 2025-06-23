package umc.spring.service.userMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.foodRepository.FoodRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.userMissionRepository.UserMissionRepository;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.web.dto.UserMissionRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

import static umc.spring.domain.enums.MissionStatus.CHALLENGING;


@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;


    @Override
    @Transactional
    public UserMission createUserMission(UserMissionRequestDTO.JoinDTO request) {

        Long userId = request.getUserAndMissionId().get(0);
        Long missionId = request.getUserAndMissionId().get(1);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        UserMission newUserMission = UserMissionConverter.toUserMission(user, mission);

        return userMissionRepository.save(newUserMission);

    }

    @Override
    public Page<UserMission> getChallengingMissionList(Long userId, Integer page) {
        page-=1;
       User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        Page<UserMission> UserPage = userMissionRepository.findAllByUserIdAndStatus(userId, CHALLENGING, PageRequest.of(page, 10));
        return UserPage;


    }

}

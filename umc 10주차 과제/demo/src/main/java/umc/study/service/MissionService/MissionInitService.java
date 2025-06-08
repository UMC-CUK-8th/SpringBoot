package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionInitService implements CommandLineRunner {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final MemberMissionRepository memberMissionRepository;


    @Override
    public void run(String... args) {
        if (missionRepository.count() == 0) {
            MissionInit();
        }
    }
    @Transactional
    public void MissionInit() {

        List<User> Users = userRepository.findAll();
        List<Mission> Missions = missionRepository.findAll();


        for (User user : Users) {
            for (Mission mission : Missions) {
                MemberMission memberMission = MemberMission.builder()
                        .user(user)
                        .mission(mission)
                        .status(Status.BEFORE_START)
                        .completedMission(0)
                        .build();
                memberMissionRepository.save(memberMission);


            }
        }



    }

}

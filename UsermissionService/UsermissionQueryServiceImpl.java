package umcstudy.study.UsermissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umcstudy.study.MemberRepository.MemberRepository;
import umcstudy.study.domain.Members;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.Usermissions;
import umcstudy.study.UsermissionRepository.UsermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import static umcstudy.study.domain.QMissions.missions;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UsermissionQueryServiceImpl implements UsermissionQueryService {

    private final UsermissionRepository usermissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Optional<Usermissions> findmission(Long id) {
        return usermissionRepository.findById(id);
    }
    @Override
    public List<Usermissions> findvisitmissions(missionVisit status) {
        List<Usermissions> filteredMissions = usermissionRepository.dynamicQueryWithBooleanBuilder(status);
        filteredMissions.forEach(Usermissions -> System.out.println("missionsname" + missions.missionname));

        return filteredMissions;
    }
    public List<Usermissions> findUnvisitmissions(missionVisit status) {
        List<Usermissions> filteredMissions = usermissionRepository.dynamicQueryWithBooleanBuilder(status);
        filteredMissions.forEach(Usermissions -> System.out.println("missionsname" + missions.missionname));

        return filteredMissions;
    }
    public long missionVisitCount(missionVisit status){
        return usermissionRepository.countVisitMission(status);
    }
    @Override
    public Page<Usermissions> getIngMissionList(Long MemberId, Integer page) {
        Members members = memberRepository.findById(MemberId).get();
        Page<Usermissions> UsermissionsPage = usermissionRepository.findByMembersAndVisitstatus(members, missionVisit.VISITING, PageRequest.of(page,10));
        return UsermissionsPage;
    }

}
package umcstudy.study.localmissionRepositoryService;

import lombok.RequiredArgsConstructor;
import umcstudy.study.DTO.LocalMissionStatusDTO;
import umcstudy.study.domain.enums.missionVisit;
import umcstudy.study.domain.mapping.locationbonusmission;
import umcstudy.study.localmissionRepository.localmissionRepository;
import umcstudy.study.UsermissionRepository.UsermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import static umcstudy.study.domain.QLocation.location;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class localmissionQueryServiceImpl implements localmissionQueryService {

    private final localmissionRepository localmissionRepository;
    private final UsermissionRepository usermissionRepository;
    @Override
    public Optional<locationbonusmission> findlocalmission(Long id) {
        return localmissionRepository.findById(id);
    }

    @Override
    public List<locationbonusmission> localname(String localname) {
        List<locationbonusmission> filteredlocations = localmissionRepository.dynamicQueryWithBooleanBuilder(localname);
        filteredlocations.forEach(locationbonusmission -> System.out.println("location: " + location.locationname));

        return filteredlocations;
    }

    @Override
    public LocalMissionStatusDTO getLocalMissionStatusWithCount(String localname, missionVisit status) {

        List<locationbonusmission> countmissions = localmissionRepository.dynamicQueryWithBooleanBuilder(localname);

        long count = usermissionRepository.countVisitMission(status); // VISITED 수
        return new LocalMissionStatusDTO(countmissions, count);
    }
}
package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.FoodCategory;
import umc.study.domain.Market;
import umc.study.domain.enums.Status;
import umc.study.repository.FoodRepository.FoodCategoryRepository;
import umc.study.repository.MarketRepository.MarketRepository;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ValidatorService {

    private final UserRepository userRepository;
    private final MarketRepository marketRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    public Market validateMarketExist(Long marketId) {
        return marketRepository.findById(marketId)
                .orElseThrow(()-> new GeneralException(ErrorStatus.MARKET_NOT_FOUND));
    }

    public boolean isMarketExist(Long marketId) {
        return marketRepository.existsById(marketId);
    }


    public boolean categoryExist(List<Long> categoryIds) {
        return categoryIds.stream()
                .allMatch(id->foodCategoryRepository.existsById(id));
    }

    public List<FoodCategory> validateCategoryExist(List<Long> categoryIds) {
        if (!categoryExist(categoryIds)) {
            throw new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
        }
        return foodCategoryRepository.findAllById(categoryIds);
    }

    public boolean validateMissionStatus(Long userId, Long missionId, Status status) {

        return memberMissionRepository.findByUserIdAndMissionId(userId,missionId)
                .map(memberMission -> memberMission.getStatus()==status)
                .orElse(false);
    }






}

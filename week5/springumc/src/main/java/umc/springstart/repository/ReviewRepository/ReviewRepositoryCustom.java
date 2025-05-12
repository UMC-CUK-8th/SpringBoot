package umc.springstart.repository.ReviewRepository;

import umc.springstart.domain.enums.MemberStatus;
import umc.springstart.dto.ReviewDto;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewDto> findStoreIdAndMemberStatus(Long id, MemberStatus memberStatus);
}
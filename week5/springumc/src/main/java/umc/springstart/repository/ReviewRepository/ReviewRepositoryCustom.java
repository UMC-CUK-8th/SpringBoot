package umc.springstart.repository.ReviewRepository;

import com.querydsl.core.Tuple;
import umc.springstart.domain.enums.MemberStatus;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Tuple> findStoreIdAndMemberStatus(Long id, MemberStatus memberStatus);
}

package umc.study.repository.ReviewRepository;

import umc.study.dto.MemberDetailDTO;
import umc.study.dto.ReviewDTO;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewDTO> secondpicture(String title, int score,
                                      String reply, String description);
}

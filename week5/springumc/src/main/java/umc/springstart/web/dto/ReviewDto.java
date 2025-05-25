package umc.springstart.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import umc.springstart.domain.enums.MemberStatus;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ReviewDto {
    private final Long reviewId;
    private final Long storeId;
    private final Long memberId;
    private final MemberStatus memberStatus;
    private final String title;
    private final LocalDateTime createdAt;

    @Override
    public String toString() {
        return "ReviewDto{" +
                "reviewId=" + reviewId +
                ", storeId=" + storeId +
                ", memberId=" + memberId +
                ", memberStatus=" + memberStatus +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
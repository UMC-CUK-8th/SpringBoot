package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long reviewId;
    private String title;
    private int score;
    private String description;
    private String reply;
    private byte[] reviewPicture;
}

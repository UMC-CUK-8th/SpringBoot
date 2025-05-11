package umc.springstart.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long reviewId) {
        super("해당 ID의 리뷰를 찾을 수 없습니다. id=" + reviewId);
    }
}
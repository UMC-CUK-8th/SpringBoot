package umc.study.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    Long insertReviewWithQueryDSL(Long missionId,Long marketId, Float rate, String description, String picure);

}

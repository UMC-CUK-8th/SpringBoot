package umcstudy.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.handler.StoreHandler;
import umcstudy.converter.ReviewConverter;
import umcstudy.converter.StoreConverter;
import umcstudy.repository.ReviewRegiRepository;
import umcstudy.repository.StoreRegiRepository;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.ReviewRequestDTO;
import umcstudy.web.dto.ReviewResponseDTO;
import umcstudy.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final StoreRegiRepository storeRegiRepository;
    private final ReviewRegiRepository reviewRegiRepository;


    @Override
    @Transactional
    public ReviewResponseDTO.RevJoinResultDTO registerReview(ReviewRequestDTO.RevJoinDto request) {
        Store store = storeRegiRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Reviews reviews = ReviewConverter.toReview(request, store);
        Reviews savedReviews= reviewRegiRepository.save(reviews);

        return ReviewConverter.toJoinResultDTO(savedReviews);
    }
}

package umcstudy.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcstudy.apiPayload.code.status.ErrorStatus;
import umcstudy.apiPayload.exception.handler.StoreHandler;
import umcstudy.converter.ReviewConverter;
import umcstudy.repository.ReviewRegiRepository;
import umcstudy.repository.StoreRegiRepository;
import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final StoreRegiRepository storeRegiRepository;
    private final ReviewRegiRepository reviewRegiRepository;


    @Override
    @Transactional
    public Reviews registerReview(ReviewRequestDTO.RevJoinDto request) {
        Store store = storeRegiRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Reviews reviews = ReviewConverter.toReview(request, store);

        return reviewRegiRepository.save(reviews);
    }
}

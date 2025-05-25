package umc.spring.service.reviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserFoodConverter;
import umc.spring.domain.*;
import umc.spring.domain.mapping.UserFood;
import umc.spring.repository.foodRepository.FoodRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.repository.userRepository.UserRepository;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinDTO request) {

        Review newReview = ReviewConverter.toReview(request);

        newReview.setStore(storeRepository.findById(request.getStore())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)));
        newReview.setUser(userRepository.findById(request.getUser())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND)));

        return reviewRepository.save(newReview);
    }

    @Override
    public Page<Review> getReviewList(Long userId, Integer page) {
        page-=1;
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        Page<Review> UserPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return UserPage;
    }
}

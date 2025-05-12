package org.example.study.ReviewService;

import org.example.study.domain.Members;
import org.example.study.domain.Store;
import org.example.study.domain.mapping.Reviews;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewQueryService {
    Optional<Reviews> findReview(Long id);
    void writeReview(String contents, int star, String memId, String storename);
}

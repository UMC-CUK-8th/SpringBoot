package org.example.study.ReviewRepository;

import org.example.study.domain.mapping.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Reviews, Long>, ReviewRepositoryCustom {
}
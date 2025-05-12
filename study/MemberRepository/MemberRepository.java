package org.example.study.MemberRepository;

import org.example.study.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Members, Long>, MemberRepositoryCustom {
    Optional<Members> findByMemID(String memId);

}
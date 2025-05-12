package org.example.study.localmissionRepository;

import org.example.study.domain.mapping.locationbonusmission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface localmissionRepository extends JpaRepository<locationbonusmission, Long>, localmissionRepositoryCustom {
}
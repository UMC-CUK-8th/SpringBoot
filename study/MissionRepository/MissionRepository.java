package org.example.study.MissionRepository;

import org.example.study.domain.Missions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MissionRepository extends JpaRepository<Missions, Long>, MissionRepositoryCustom {
}
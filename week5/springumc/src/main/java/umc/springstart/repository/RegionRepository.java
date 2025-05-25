package umc.springstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springstart.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
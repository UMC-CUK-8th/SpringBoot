package umc.study.repository.PreferencesRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Preferences;

public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
}

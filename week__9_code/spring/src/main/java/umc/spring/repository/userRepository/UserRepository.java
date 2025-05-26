package umc.spring.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

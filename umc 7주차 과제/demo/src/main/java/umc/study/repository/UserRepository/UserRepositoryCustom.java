package umc.study.repository.UserRepository;

import umc.study.domain.User;

import java.util.List;

public interface UserRepositoryCustom {
    User findByUserId(Long userId);
}

package Concurrency_Project.Hello_Concurrency.user.Repository;

import Concurrency_Project.Hello_Concurrency.user.dto.UserResponseDto;
import Concurrency_Project.Hello_Concurrency.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsername(String username);

    /*@Query("select U u.username, u.email, u.postCount, u.socialLogin from User u where u.id = :userId")
    Optional<UserResponseDto.UserInfoDto> findUserInfoByUserId(Long userId);*/

    /*@Query("select new Concurrency_Project.Hello_Concurrency.user.dto.UserResponseDto.UserInfoDto(u.username, u.email, u.postCount, u.socialLogin) from User u where u.id = :userId")
    Optional<UserResponseDto.UserInfoDto> findUserInfoByUserId(@Param("userId") Long userId);*/

}

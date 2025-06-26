package umcstudy.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umcstudy.repository.MemberRegiRepository;
import umcstudy.study.MemberRepository.MemberRepository;
import umcstudy.study.domain.Members;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRegiRepository memberRegiRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Members members = memberRegiRepository.findByMemID(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디을 가진 유저가 존재하지 않습니다: " + username));

        System.out.println(">> 로그인 시도: " + username);
        System.out.println(">> DB에서 조회된 회원 ID: " + members.getMemID());
        System.out.println(">> 암호화된 비밀번호: " + members.getPassword());
        System.out.println(">> 권한: " + members.getRole().name());


        return org.springframework.security.core.userdetails.User
                .withUsername(members.getMemID())
                .password(members.getPassword())
                .roles(members.getRole().name())
                .build();
    }
}
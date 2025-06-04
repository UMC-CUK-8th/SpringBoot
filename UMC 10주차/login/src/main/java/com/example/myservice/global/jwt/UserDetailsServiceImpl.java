package com.example.myservice.global.jwt;

import com.example.myservice.domain.user.entity.User;
import com.example.myservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                        () -> new UsernameNotFoundException("Not found user with this email: " +email)
                );


        if(user != null){
            return new UserDetailsImpl(user);
        }else {
            return null;
        }
    }
}

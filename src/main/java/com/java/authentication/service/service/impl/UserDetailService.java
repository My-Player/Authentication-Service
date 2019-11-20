package com.java.authentication.service.service.impl;

import com.java.authentication.service.dao.UserRepository;
import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<UserData> optionalUser = userRepository.findByUserEmail(userEmail);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("UserData Email not Found!"));

        return optionalUser.map(JwtUserDetails::new).get();
    }
}

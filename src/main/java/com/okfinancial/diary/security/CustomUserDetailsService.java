package com.okfinancial.diary.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.okfinancial.diary.dao.UserRepository;
import com.okfinancial.diary.domain.User;

//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findOneByName(username);
//        if(user == null){
//            throw new UsernameNotFoundException("not found");
//        }
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
//        System.err.println("username is " + username + ", " + user.getRole().name());
//        return new org.springframework.security.core.userdetails.User(user.getName(),
//                "123456", authorities);
//    }
//
//}

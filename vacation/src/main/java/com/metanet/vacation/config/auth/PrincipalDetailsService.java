package com.metanet.vacation.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metanet.vacation.model.MetanetUser;
import com.metanet.vacation.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// /login 요청이 올때 동작함.
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

   private final UserRepository userRepository;
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      System.out.println("PrincipalDetailsService : 진입");
      MetanetUser user = userRepository.findByUsername(username);
      System.out.println("PrincipalDetailsService : 수행완료");
      return new PrincipalDetails(user);
   }
}
package com.metanet.vacation.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.metanet.vacation.model.Account;
import com.metanet.vacation.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
   private final AccountRepository userRepository;

   public CustomUserDetailsService(AccountRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   @Transactional
   public UserDetails loadUserByUsername(final String username) {
      return userRepository.findOneWithAuthoritiesByUsername(username)
         .map(user -> createUser(username, user))
         .orElseThrow(() -> new UsernameNotFoundException(username + " -> �����ͺ��̽����� ã�� �� �����ϴ�."));
   }

   private org.springframework.security.core.userdetails.User createUser(String username, Account user) {
      if (!user.isActivated()) {
         throw new RuntimeException(username + " -> Ȱ��ȭ�Ǿ� ���� �ʽ��ϴ�.");
      }
      List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
              .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
              .collect(Collectors.toList());
      return new org.springframework.security.core.userdetails.User(user.getUsername(),
              user.getPassword(),
              grantedAuthorities);
   }
}
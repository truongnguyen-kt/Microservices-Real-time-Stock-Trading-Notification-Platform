package com.blues.microservices_realtime_stock_trading_and_notification_platform.service;

import com.blues.microservices_realtime_stock_trading_and_notification_platform.dto.UserDetailsImpl;
import com.blues.microservices_realtime_stock_trading_and_notification_platform.entity.AppUser;
import com.blues.microservices_realtime_stock_trading_and_notification_platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        } else {
            return new UserDetailsImpl(user.get());
        }
    }
}

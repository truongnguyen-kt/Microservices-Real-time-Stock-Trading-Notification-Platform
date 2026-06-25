package com.blues.microservices_realtime_stock_trading_and_notification_platform.repository;

import com.blues.microservices_realtime_stock_trading_and_notification_platform.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}

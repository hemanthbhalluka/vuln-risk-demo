package com.demo.app.repository;
import com.demo.app.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {}
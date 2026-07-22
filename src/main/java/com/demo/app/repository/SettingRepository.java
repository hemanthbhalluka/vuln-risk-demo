package com.demo.app.repository;
import com.demo.app.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SettingRepository extends JpaRepository<Setting, Long> {}
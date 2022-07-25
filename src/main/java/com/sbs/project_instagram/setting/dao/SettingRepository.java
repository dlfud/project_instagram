package com.sbs.project_instagram.setting.dao;

import com.sbs.project_instagram.setting.domain.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
}

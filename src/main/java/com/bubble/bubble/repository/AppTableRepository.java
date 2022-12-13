package com.bubble.bubble.repository;

import com.bubble.bubble.entity.AppTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppTableRepository extends JpaRepository<AppTable,Long> {
  List<AppTable> findByAppId(long appId);
}

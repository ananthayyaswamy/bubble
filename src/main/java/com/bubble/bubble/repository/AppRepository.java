package com.bubble.bubble.repository;

import com.bubble.bubble.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AppRepository extends JpaRepository<App,Long> {
    List<App> findByUserTableId(long UserId);

}

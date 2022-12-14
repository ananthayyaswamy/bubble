package com.bubble.bubble.repository;

import com.bubble.bubble.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
User findByEmail(String email);
User findByUserName(String userName);
User findById(long userId);

}

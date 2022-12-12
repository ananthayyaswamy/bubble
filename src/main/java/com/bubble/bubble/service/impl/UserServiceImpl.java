package com.bubble.bubble.service.impl;

import com.bubble.bubble.entity.AppTable;
import com.bubble.bubble.entity.User;
import com.bubble.bubble.repository.UserRepository;
import com.bubble.bubble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser (User user){
        User user1 =userRepository.save(user);
        return user;
    }

    @Override
    public User loginUser(User user) {
        System.out.println(user.toString());
        User user1 = userRepository.findByEmail(user.getEmail());
        if (user1 != null) {
            if (user1.getPassword().equals(user.getPassword())) {
                return user1;
            }
        } else {
            User user2 = userRepository.findByUserName(user.getUserName());
            if (user2 != null) {
                if (user2.getPassword().equals(user.getPassword())) {
                    return user2;

                }
            }
        }
        return null;
    }

}


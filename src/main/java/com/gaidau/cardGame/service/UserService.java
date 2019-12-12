package com.gaidau.cardGame.service;

import com.gaidau.cardGame.ResourceNotFoundException;
import com.gaidau.cardGame.bean.User;
import com.gaidau.cardGame.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Integer id){
        return userRepository.findById((id)).orElseThrow(() -> new ResourceNotFoundException
                ("No user found for  id="+id));
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public User createPost(User post)
    {
        return userRepository.save(post);
    }
}

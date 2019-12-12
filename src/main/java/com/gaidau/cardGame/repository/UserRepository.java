package com.gaidau.cardGame.repository;

import com.gaidau.cardGame.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

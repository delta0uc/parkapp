package com.delta.parking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delta.parking.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}

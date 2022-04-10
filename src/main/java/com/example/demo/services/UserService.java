package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public ArrayList<UserModel> getAllUsers() {
    return (ArrayList<UserModel>) userRepository.findAll();
  }

  public Optional<UserModel> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public UserModel createUser(UserModel user) {
    return userRepository.save(user);
  }

  public ArrayList<UserModel> getUsersByPriority(Integer priority) {
    return userRepository.findByPriority(priority);
  }

  public boolean deleteUser(Long id) {
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}

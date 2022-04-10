package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
  public abstract ArrayList<UserModel> findByPriority(Integer priority);
}

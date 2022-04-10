package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ResponseModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping()
  public ResponseModel<?> getAllUsers() {
    try {
      ArrayList<UserModel> data = userService.getAllUsers();

      ResponseModel response = new ResponseModel<ArrayList<UserModel>>();
      response.setStatus(true);
      response.setMessage("Success");
      response.setData(data);

      return response;
    } catch (Exception e) {
      ResponseModel response = new ResponseModel<ArrayList<UserModel>>();
      response.setStatus(false);
      response.setMessage("" + e);
      response.setData(null);

      return response;
    }
  }

  @PostMapping()
  public ResponseModel<?> createUser(@RequestBody UserModel user) {
    try {
      UserModel data = userService.createUser(user);

      ResponseModel response = new ResponseModel<UserModel>();
      response.setStatus(true);
      response.setMessage("Success");
      response.setData(data);

      return response;
    } catch (Exception e) {
      ResponseModel response = new ResponseModel<UserModel>();
      response.setStatus(false);
      response.setMessage("" + e);
      response.setData(null);

      return response;
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseModel<?> getUserById(@PathVariable("id") Long id) {
    Optional<UserModel> data = userService.getUserById(id);
    boolean status = data != null ? true : false;
    String message = data != null ? "Success" : "User not found";

    ResponseModel response = new ResponseModel<Optional<UserModel>>();
    response.setStatus(status);
    response.setMessage(message);
    response.setData(data);

    return response;
  }

  @GetMapping("/query")
  public ResponseModel<?> getUsersByPriority(@RequestParam("priority") Integer priority) {
    ArrayList<UserModel> data = userService.getUsersByPriority(priority);

    ResponseModel response = new ResponseModel<ArrayList<UserModel>>();
    response.setStatus(true);
    response.setMessage("Success");
    response.setData(data);

    return response;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseModel<?> deleteUser(@PathVariable("id") Long id) {
    boolean status = this.userService.deleteUser(id);

    ResponseModel response = new ResponseModel<UserModel>();
    response.setStatus(status ? true : false);
    response.setMessage(status ? "Success" : "User not found");
    response.setData(null);

    return response;
  }

}
